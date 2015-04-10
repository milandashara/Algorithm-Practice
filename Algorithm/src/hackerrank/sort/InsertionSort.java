package hackerrank.sort;

import java.util.Scanner;

/**
 * Insertion Sort Algorithm
 * @author Milan
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int a[] = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = scanner.nextInt();
		}

		insertionSort(a);
	}

	/**
	 * Insertion sort algorithm
	 * 
	 * @param a
	 */
	private static void insertionSort(int a[]) {
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
			} else {
				a[i + 1] = element;
				printArray(a);
				break;
			}
			if (i == 0) {
				a[i] = element;
				printArray(a);
			}

		}
	}

	/**
	 * Print array
	 * 
	 * @param a
	 */
	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
