import java.util.Scanner;


/*Problem Statement: 
 * You are given N Books, ith of which has P(i) pages(P(i)<=P(j). If i<=j). 
 * You have to assign these N books to M students such that each student has one or more books 
 * and the maximum number of pages assigned to a student is minimized.
 * 
 * >> Input:
 * First Line contains N & M; Number of books & Number of students
 * Second Line contains space separated P; Number of pages for each book respectively
 * 
 * >> Output:
 * M; To find Maximum number of page read by student in 
 * */

/**
 * 
 * @author Nikhil Khatri
 *
 */
public class BookAllocationProblem {

	static int books;
	static int students;
	static int[] bookPages;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] bookStudents = sc.nextLine().split(" ");
		String[] pagesOfBook = sc.nextLine().split(" ");
		
		sc.close();
		books = Integer.parseInt(bookStudents[0]);
		students = Integer.parseInt(bookStudents[1]);
		bookPages = new int[books];
		if(books<students){
			System.out.println("Number of Books must not be less than number of Students");
			return;
		}
		int sumOfAllPages=0;
		for(int i=0;i<pagesOfBook.length;i++){
			bookPages[i]=Integer.parseInt(pagesOfBook[i]);
			sumOfAllPages=sumOfAllPages+bookPages[i];
		}
		System.out.println("Maximum of minimum page: "+findMaxOfMinAllocatedPageByBinarySearch(bookPages[0],sumOfAllPages));
	}

	public static int findMaxOfMinAllocatedPageByBinarySearch(int lowerBound,int upperBound){
		if(lowerBound>=(upperBound-1)){
			return upperBound;
		}
		
		int midValue = (lowerBound+upperBound)/2;
		if(doesAllBooksAllocateToAllStudent(midValue)){
			return findMaxOfMinAllocatedPageByBinarySearch(lowerBound,midValue);
		}else{
			return findMaxOfMinAllocatedPageByBinarySearch(midValue,upperBound);
		}
	}

	private static boolean doesAllBooksAllocateToAllStudent(int maxPages) {
		int lastPageIndex = 0;
		int count=0;
		for(int i=1;i<=students;i++){
			int studentPages = 0;
			for(int j=lastPageIndex;j<bookPages.length;j++){
				studentPages=studentPages+bookPages[j];
				
				if(studentPages>maxPages){
					lastPageIndex=j;
					studentPages=studentPages-bookPages[j];
					//System.out.println("Student "+i+" ,Pages "+studentPages);
					break;
				}
				//System.out.print(bookPages[j]+",");
				
				if(j==bookPages.length-1){
					lastPageIndex=j+1;
					//System.out.println("Student "+i+" ,Pages "+studentPages);
				}
				++count;
			}
		}
		if(count==bookPages.length && count>=students){
			//System.out.println("*** Valid for MaxPage "+maxPages);
			return true; 
		}else{
			//System.out.println("*** Not Valid for MaxPage "+maxPages);
		}
		return false;
	}
}
