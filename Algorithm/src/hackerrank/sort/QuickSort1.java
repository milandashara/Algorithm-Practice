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
public class QuickSort1 {
	
	/**
	 * Partition array such that all element left of pivot are less and all element right of pivot are greater
	 * keeping other numbers in place
	 * @param ar
	 */
	static void partition(int[] ar) {
		int pivot = 0;
		int pivotVal = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] < pivotVal) {
				int element = ar[i];

				for (int j = i; j > pivot; j--) {
					ar[j] = ar[j - 1];
				}

				ar[pivot] = element;
				ar[pivot + 1] = pivotVal;
				pivot++;

			}

		}
		
		

		printArray(ar);
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
		partition(ar);
	}
}
