package com.sortings.A_SelectionSort;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class SelectionSort<T> {
	
	private  BiFunction<T,T,Integer> comparatorFunction;
	
	public SelectionSort(BiFunction<T, T, Integer> comparatorFunction) {
		super();
		this.comparatorFunction = comparatorFunction;
	}
	
	public static void main(String[] args) {
		List<String> elements = Arrays.asList("Apocalypse","Arhan","Zenith","Wrold War Z","Mortal Kombat","Harry Potter -1", "Harry Potter -2","Matrix","Interestellar","Gravity","Shawshank Redemption","Inception","Blood Diamond","The Boy who harnessed wind","Titanic");
		
		SelectionSort<String> sortUtil = new SelectionSort<>((String a, String b)->{return a.compareTo(b);});
		
		System.out.println(sortUtil.sortBySelectionSort(elements));
	}

	public List<T> sortBySelectionSort(List<T> collection) {
		T[] collArray = (T[]) collection.toArray();
		for(int i=0; i<collection.size();i++) {
			for(int j=i;j<collection.size();j++) {
				if(comparatorFunction.apply(collArray[i], collArray[j]) > 0) {
					T objOnPointer = collArray[i];
					collArray[i] = collArray[j];
					collArray[j] = objOnPointer;
				}
			}
		}
		
		return  Arrays.asList(collArray);
	}
}
