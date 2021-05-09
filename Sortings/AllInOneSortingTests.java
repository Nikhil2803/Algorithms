package com.sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AllInOneSortingTests {
	
	public static void main(String[] args) {
		
		List<String> elements = Arrays.asList("Apocalypse","Arhan","Zenith","Wrold War Z","Mortal Kombat","Harry Potter -1", "Harry Potter -2","Matrix","Interestellar","Gravity","Shawshank Redemption","Inception","Blood Diamond","The Boy who harnessed wind","Titanic");
		System.out.println(elements);
		System.out.println(sortBySelectionSort(elements, (String a, String b)->{return a.compareTo(b);}));
		System.out.println(sortByBubbleSort(elements, (String a, String b)->{return a.compareTo(b);}));
		System.out.println(sortByInsertionSort(elements, (String a, String b)->{return a.compareTo(b);}));
		System.out.println(sortByQuickSort(elements, (String a, String b)->{return a.compareTo(b);}));
		System.out.println(sortByMergeSort( elements,(String a, String b)->{return a.compareTo(b);} ));
	}

	public static <T> List<T> sortBySelectionSort(List<T> collection, BiFunction<T,T,Integer> comparatorFunction) {
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
	
	public static <T> List<T> sortByBubbleSort(List<T> collection, BiFunction<T,T,Integer> comparatorFunction) {
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
	
	public static <T> List<T> sortByInsertionSort(List<T> collection, BiFunction<T,T,Integer> comparatorFunction) {
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
	
	public static <T> List<T> sortByQuickSort(List<T> collection, BiFunction<T,T,Integer> comparatorFunction) {
		LinkedList<T> linkedList = new LinkedList<>();
		linkedList.addAll(collection);
		
		return recursiveQuickSort(linkedList,0,linkedList.size()-1,comparatorFunction);
	}
	
	private static <T> List<T> recursiveQuickSort(List<T> collection,int low, int high,  BiFunction<T,T,Integer> comparatorFunction){
		if(low < high) {
			int pivot = sortedPartition(collection,low,high,comparatorFunction);
			if(pivot == low) {
				++pivot;
				++low;
			}
			recursiveQuickSort(collection,low,pivot,comparatorFunction);
			recursiveQuickSort(collection,pivot,high,comparatorFunction);
		}
		return collection;
	}
	private static <T> int sortedPartition(List<T> collection,int low, int high, BiFunction<T,T,Integer> comparatorFunction){
		
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

	public static <T> List<T> sortByMergeSort(List<T> collection, BiFunction<T,T,Integer> comparatorFunction) {
		if(collection.size()==1) {
			return collection;
		}else {
			int midIndex = collection.size()/2;
			List<T> left = sortByMergeSort(collection.subList(0,midIndex),comparatorFunction);
			List<T> right = sortByMergeSort(collection.subList(midIndex,collection.size()),comparatorFunction);
			return mergeSortedCollection(left,right,comparatorFunction);
		}
	}
	
	private static <T> List<T> mergeSortedCollection(List<T> collectionA,List<T> collectionB
			,BiFunction<T,T,Integer> comparatorFunction){
		
		List<T> newCollection = new ArrayList<T>(collectionA.size()+collectionB.size());
		
		int collAPointer =0;
		int collBPointer =0;
		
		while(collAPointer < collectionA.size()  || collBPointer < collectionB.size()) {
			
			if(collAPointer < collectionA.size()  
					&& collBPointer >= collectionB.size()) {
				newCollection.add(collectionA.get(collAPointer));
				++collAPointer;
			}
			else if(collBPointer < collectionB.size()  
					&& collAPointer >= collectionA.size()) {
				newCollection.add(collectionB.get(collBPointer));
				++collBPointer;
			}
			else if( comparatorFunction
					.apply(collectionA.get(collAPointer)
							,collectionB.get(collBPointer))<0) {
				newCollection.add(collectionA.get(collAPointer));
				++collAPointer;
			}else if(comparatorFunction
					.apply(collectionA.get(collAPointer)
							,collectionB.get(collBPointer))>=0){
				newCollection.add(collectionB.get(collBPointer));
				++collBPointer;
			}
		
		}

		return newCollection;
	}
	
}
