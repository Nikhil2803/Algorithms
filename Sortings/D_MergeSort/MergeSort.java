package com.sortings.D_MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class MergeSort<T> {

	private  BiFunction<T,T,Integer> comparatorFunction;

	public MergeSort(BiFunction<T, T, Integer> comparatorFunction) {
		super();
		this.comparatorFunction = comparatorFunction;
	}
	
	public static void main(String[] args) {
		List<String> elements = Arrays.asList("Apocalypse","Arhan","Zenith","Wrold War Z","Mortal Kombat","Harry Potter -1", "Harry Potter -2","Matrix","Interestellar","Gravity","Shawshank Redemption","Inception","Blood Diamond","The Boy who harnessed wind","Titanic");
		
		MergeSort<String> mergeSortUtil = new MergeSort<>((String a, String b)->{return a.compareTo(b);});
		System.out.println(mergeSortUtil.sortByMergeSort(elements));
	}
	
	
	public  List<T> sortByMergeSort(List<T> collection) {
		if(collection.size()==1) {
			return collection;
		}else {
			int midIndex = collection.size()/2;
			List<T> left = sortByMergeSort(collection.subList(0,midIndex));
			List<T> right = sortByMergeSort(collection.subList(midIndex,collection.size()));
			return mergeSortedCollection(left,right);
		}
	}
	
	private List<T> mergeSortedCollection(List<T> collectionA,List<T> collectionB){
		
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
