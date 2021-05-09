package com.sortings.C_InsertionSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class InsertionSort<T> {
	
	private  BiFunction<T,T,Integer> comparatorFunction;
	
	public InsertionSort(BiFunction<T, T, Integer> comparatorFunction) {
		super();
		this.comparatorFunction = comparatorFunction;
	}

	public static void main(String[] args) {
		List<String> elements = Arrays.asList("Apocalypse","Arhan","Zenith","Wrold War Z","Mortal Kombat","Harry Potter -1", "Harry Potter -2","Matrix","Interestellar","Gravity","Shawshank Redemption","Inception","Blood Diamond","The Boy who harnessed wind","Titanic");
		
		InsertionSort<String> sortUtil = new InsertionSort<>((String a, String b)->{return a.compareTo(b);});
		
		System.out.println(sortUtil.sortByInsertionSort(elements));
	}
	
	public List<T> sortByInsertionSort(List<T> collection) {
		LinkedList<T> linkedList = new LinkedList<>();
		linkedList.addAll(collection);
		
		for(int i=0; i<linkedList.size();i++) {
				int pointer = i;
				
				while(pointer > -1 
						&& comparatorFunction.apply(linkedList.get(i),linkedList.get(pointer)) <= 0) {
					--pointer;
				}
				if(pointer < i
						&& comparatorFunction.apply(linkedList.get(i), linkedList.get(pointer+1)) < 0) {
					linkedList.add(pointer+1, linkedList.remove(i));
				}
		}
		
		return  linkedList;
	}
}
