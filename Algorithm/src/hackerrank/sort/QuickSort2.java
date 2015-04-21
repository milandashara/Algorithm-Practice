package hackerrank.sort;

import java.util.Scanner;

/**
 * Sample Input 5 4 5 3 7 2
 * 
 * Sample Output 3 2 4 5 7
 * 
 * p is pivot
 * 
 * @author Milan
 * 
 */
public class QuickSort2 {

	/**
	 * Partition array such that all element left of pivot are less and all
	 * element right of pivot are greater keeping other numbers in place
	 * 
	 * @param ar
	 */
	static void partition(int[] ar, int start, int end) {

		// condition to stop recursion
		if (start >= end)
			return;

		// pivot is first element
		int pivot = start;
		int pivotVal = ar[pivot];

		// all element to left are less than pivot value and all element to
		// right are more than pivot value
		for (int i = start + 1; i <= end; i++) {
			if (ar[i] < pivotVal) {
				int element = ar[i];

				// shift element to left
				for (int j = i; j > pivot; j--) {
					ar[j] = ar[j - 1];
				}

				// swap
				ar[pivot] = element;
				ar[pivot + 1] = pivotVal;
				pivot++;

			}

		}

		// left partition
		if (pivot - 1 > start)
			partition(ar, start, pivot - 1);

		// right partition
		if (pivot + 1 < end)
			partition(ar, pivot + 1, end);

		// if (start != pivot)
		printArray(ar, start, end);

	}

	static void quickSort(int[] ar) {
		partition(ar, 0, ar.length - 1);
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
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		quickSort(ar);

	}
}
