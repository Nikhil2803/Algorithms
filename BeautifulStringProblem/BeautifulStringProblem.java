package com.problem;

import java.util.Scanner;

/*A Beautiful string is a string which has all same characters. Example BBBBBB, AAAAAAA 
 * Objective is to get maximum size of any beautiful substring from a given string. 
 * Given string would only contain A or B as characters. 
 * K will be the input for number of characters that could be changed to form a beautiful string. 
 * S will be the main string*/

/*Input :  
 * > K ; 2 ;Number of letters that could be changed to form beautiful string.
 * > S ; ABBBABBBABBBABAB ; String from which beautiful string is formed
 */

/*Output :  
 * > K ; 7 ;Max size of a beautiful substring
 */


public class BeautifulStringProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfCharChangeAllowed = Integer.parseInt(sc.nextLine());
		String mainString = sc.nextLine();
		sc.close();
		
		int maxSubstring = solveByBinarySearch(0,mainString.length(),numOfCharChangeAllowed,mainString);
		System.out.println(maxSubstring);
	}
	
	
	public static int solveByBinarySearch(int minSize, int maxSize,int numOfCharChng, String string){
		
		int maxSizeOfBeautifulString = 0;
		if(minSize > maxSize || maxSize < minSize){
			return 0;
		}
		
		int sizeForAnalyzing = (minSize+maxSize)/2;
		if(doesBeautifulSubStringOfGivenSizeExist(sizeForAnalyzing,numOfCharChng,string)){
			maxSizeOfBeautifulString = solveByBinarySearch(sizeForAnalyzing+1,maxSize,numOfCharChng,string);
			if(maxSizeOfBeautifulString<sizeForAnalyzing)
				maxSizeOfBeautifulString=sizeForAnalyzing;
		}else{
			maxSizeOfBeautifulString = solveByBinarySearch(minSize,sizeForAnalyzing-1,numOfCharChng,string);
		}
		return maxSizeOfBeautifulString;
	}
	
	public static boolean doesBeautifulSubStringOfGivenSizeExist(int subtringSize,int numOfCharChng, String string){
		if(subtringSize==1)
			return true;
		for(int i=0;i<=string.length()-subtringSize;i++){
			int[][] charFreq = getCharacterFreqInString(string.substring(i, i+subtringSize), 'A', 'B');
			if(charFreq[0][0]<=numOfCharChng || charFreq[0][1]<=numOfCharChng){
				return true;
			}
		}
		return false;
	}
	
	public static int[][] getCharacterFreqInString(String string, char a, char b){
		int[][] charFreq = {{0,0}};
		char[] charArr = string.toCharArray();
		for(char chr: charArr){
			if(chr==a){
				charFreq[0][0]=++charFreq[0][0];
			}else if (chr==b){
				charFreq[0][1]=++charFreq[0][1];
			}
		}
		return charFreq;
	}
}
