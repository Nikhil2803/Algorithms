package com.sortings.E_QuickSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class QuickSort<T> {

	private  BiFunction<T,T,Integer> comparatorFunction;
	
	
	public QuickSort(BiFunction<T, T, Integer> comparatorFunction) {
		super();
		this.comparatorFunction = comparatorFunction;
	}
	
	public static void main(String[] args) {
		List<String> elements = Arrays.asList("Apocalypse","Arhan","Zenith","Wrold War Z","Mortal Kombat","Harry Potter -1", "Harry Potter -2","Matrix","Interestellar","Gravity","Shawshank Redemption","Inception","Blood Diamond","The Boy who harnessed wind","Titanic");
		
		QuickSort<String> sortUtil = new QuickSort<>((String a, String b)->{return a.compareTo(b);});
		
		System.out.println(sortUtil.sortByQuickSort(elements));
	}

	public List<T> sortByQuickSort(List<T> collection) {
		LinkedList<T> linkedList = new LinkedList<>();
		linkedList.addAll(collection);
		
		return recursiveQuickSort(linkedList,0,linkedList.size()-1);
	}
	
	private List<T> recursiveQuickSort(List<T> collection,int low, int high){
		if(low < high) {
			int pivot = sortedPartition(collection,low,high);
			if(pivot == low) {
				++pivot;
				++low;
			}
			recursiveQuickSort(collection,low,pivot);
			recursiveQuickSort(collection,pivot,high);
		}
		return collection;
	}
	
	private  int sortedPartition(List<T> collection,int low, int high){
		
		int forwardPointer = low;
		int backwardPointer = high;
		
		T pivot = collection.get(forwardPointer);
		
		while(forwardPointer < backwardPointer) {
			do {
				forwardPointer++;
			}while(forwardPointer <= high-1 
					&& comparatorFunction
					.apply(collection.get(forwardPointer)
							,pivot) <= 0);
			
			while(comparatorFunction
					.apply(collection.get(backwardPointer)
							,pivot) > 0) {
				backwardPointer--;
			}
			
			if(forwardPointer < backwardPointer) {
				T temp = collection.get(forwardPointer);
				collection.set(forwardPointer, collection.get(backwardPointer));
				collection.set(backwardPointer, temp);
			}
		}
		if(backwardPointer > low) {
			pivot = collection.get(low);
			collection.set(low, collection.get(backwardPointer));
			collection.set(backwardPointer, pivot);
			
		}
		return backwardPointer;
	}
}
