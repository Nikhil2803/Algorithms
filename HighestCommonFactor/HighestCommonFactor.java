package com.algorithms.math;

public class HighestCommonFactor {

	public static void main(String[] args) {
		System.out.println(getHCF(18,21));
	}
	
	public static int getHCF(int a, int b) {
		if(a%b == 0) {
			return b;
		}
		if(a > b) {
			return getHCF(b, a%b);
		}else {
			return getHCF(a, b%a);
		}
	}
}
