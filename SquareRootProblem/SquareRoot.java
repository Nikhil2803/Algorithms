

import java.util.Scanner;

/*	To Find Square root of a given number
 *  Square root of perfect square would be integer : Root of 4 = 2
 * 	Square root of imperfect square would be fractional number : Root of 2 = 1.414
 * 	Square root of negative  number would be imaginary number with iota : Root of -4 = 2i
*/

/*Input :  
 * > N = 2; Number for which square root is to be determined.
 */

/*Output :  
 * > K ; 7 ;Square Root of Given Number.
 */

public class SquareRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numForSqrRoot = Integer.parseInt(sc.nextLine());
		sc.close();
		
		String sqrRoot = String.valueOf(findRealPartSquareRootOf(0,numForSqrRoot,numForSqrRoot));
		sqrRoot = numForSqrRoot<0?sqrRoot+"i":sqrRoot;
		System.out.println(sqrRoot);
	}
	
	public static double findRealPartSquareRootOf(double lowerVal, double upperVal, double rootOf){
		double realSqrRoot = 0.0d;
		rootOf = Math.abs(rootOf);
		lowerVal = Math.abs(lowerVal);
		upperVal = Math.abs(upperVal);
		double midVal = (lowerVal+upperVal)/2;
		
		if((Math.abs(rootOf - midVal*midVal)<=0.005) 
				|| lowerVal>=upperVal){
			return midVal;
		}else if (midVal*midVal<rootOf){
			return findRealPartSquareRootOf(midVal,upperVal,rootOf);
		}else if(midVal*midVal>rootOf){
			return findRealPartSquareRootOf(lowerVal,midVal,rootOf);
		}
		return realSqrRoot;
	}

}
