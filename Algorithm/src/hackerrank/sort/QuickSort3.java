package hackerrank.sort;

import java.util.Scanner;

/*
 * In place Quick Sort
 * 
 * The In-place Trick

If an element is lower than the pivot, you should swap it with a larger element on the left-side of the sub-array.
Greater elements should remain where they are.
At the end of the partitioning method, the pivot should be swapped with the first element of the right partition, consisting of all larger elements, of the sub-array.
To ensure that you don't swap a small element with another small element, use an index to keep track of the small elements that have already been swapped into their "place".
 * @author Milan
 * 
 */
public class QuickSort3 {
	
	private static int quickSortswapCount=0;
	private static int count=0;
	

	/**
	 * Partition array such that all element left of pivot are less and all
	 * element right of pivot are greater keeping other numbers in place
	 * 
	 * @param ar
	 */
	static void partition(int[] ar, int start, int end) {

		int pivot = start;
		int pivotValue = ar[end - 1];

		for (int i = start; i < end - 1; i++) {
			if (ar[i] < pivotValue && pivot == i) {
				pivot++;
				quickSortswapCount++;
			} else if (ar[i] < pivotValue) {
				swap(ar, pivot, i);
				pivot++;
			}
		}

		swap(ar, pivot, end - 1);
		//printArray(ar);
		// left partition
		if (pivot - 1 > start)
			partition(ar, start, pivot);

		// right partition
		if (pivot + 1 < end - 1)
			partition(ar, pivot + 1, end);

		// if (start != pivot)

	}

	private static void swap(int[] ar, int i1, int i2) {
		int value = ar[i2];
		ar[i2] = ar[i1];
		ar[i1] = value;
		quickSortswapCount++;

	}

	static void quickSort(int[] ar) {
		partition(ar, 0, ar.length);
	}

	static void printArray(int[] ar, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		int[] ar1 = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
			ar1[i]=ar[i];
		}
		count=0;
		quickSortswapCount=0;
		quickSort(ar);
		insertionSort(ar1);
		System.out.println(count-quickSortswapCount);

	}
	
	/**
	 * Insertion sort algorithm
	 * 
	 * @param a
	 */
	public static void insertionSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			insertIntoSortedArray(a, i, a[i]);
		}

	}

	/**
	 * Insert element into sorted array. lastIndex : element at lastIndex is to
	 * be insert into array[0-lastIndex-1] element: element to insert in sorted
	 * array
	 * 
	 * @param a
	 * @param element
	 */
	public static void insertIntoSortedArray(int a[], int lastIndex, int element) {
		for (int i = lastIndex - 1; i >= 0; i--) {
			if (a[i] > element) {
				a[i + 1] = a[i]; // shift
				// printArray(a);
				count++;
			} else {
				a[i + 1] = element;
				//printArray(a);
				break;
			}
			if (i == 0) {
				a[i] = element;
				//printArray(a);
			}

		}
	}

}
