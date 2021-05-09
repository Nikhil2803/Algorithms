package com.sortings.B_BubbleSort;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BubleSort<T> {
	
	private  BiFunction<T,T,Integer> comparatorFunction;
	
	public BubleSort(BiFunction<T, T, Integer> comparatorFunction) {
		super();
		this.comparatorFunction = comparatorFunction;
	}

	public static void main(String[] args) {
		List<String> elements = Arrays.asList("Apocalypse","Arhan","Zenith","Wrold War Z","Mortal Kombat","Harry Potter -1", "Harry Potter -2","Matrix","Interestellar","Gravity","Shawshank Redemption","Inception","Blood Diamond","The Boy who harnessed wind","Titanic");
		
		BubleSort<String> sortUtil = new BubleSort<>((String a, String b)->{return a.compareTo(b);});
		
		System.out.println(sortUtil.sortByBubbleSort(elements));
	}
	
	public  List<T> sortByBubbleSort(List<T> collection) {
		T[] collArray = (T[]) collection.toArray();
		
		for(int i=collection.size(); i>0;i--) {
			
			for(int j=0;j<i-1;j++) {
				
				int pointer1 = j;
				int pointer2 = j+1;
				if(comparatorFunction.apply(collArray[pointer1], collArray[pointer2]) > 0){
					T objOnPointer = collArray[pointer1];
					collArray[pointer1] = collArray[pointer2];
					collArray[pointer2] = objOnPointer;
				}
			}
		}
		
		return  Arrays.asList(collArray);
	}
}
