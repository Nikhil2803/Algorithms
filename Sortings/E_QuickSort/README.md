# Quick Sort

Idea: 
-----

Pivot element is placed on its sorted position.
where all elemets smaller than it are on one side 
and all elements bigger than it are on another side.

Technique:
-----

Select a pivot and remove it.
Run two pointers in opposite directions.
Stop forward pointer if pointer element is bigger than pivot
Stop backward pointer if pointer element is smaller than pivot.
Swap the pointer elements
Stops both the pointer when they cross eachother.
Swap the pivot element with backward pointer.
Repeat the process itteratively for smaller sections of collection.
Smaller sections ( Divide collection /2/2/2/2/2)


* Divide and concure technique.

* Best time complexity in Best and average case

* It has does not have high memory footprint like merge sort as it swaps the elements of same collection

* Good for in-memory sorting 

Time complecity : (Best = 0(log-n)) (Average = 0(log-n)) (Worst = 0(n2))

# Quick Sorting
![Merge Sort](quicksort.gif)
