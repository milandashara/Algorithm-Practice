package hackerrank.sort;

import java.util.Scanner;

/**
 * Insert Element to sorted array
 * 
 * @author Milan
 *
 */
public class InsertIntoSorted {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int a[] = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = scanner.nextInt();
		}

		int element = a[size - 1]; // element to insert is at end

		insertIntoSortedArray(a, element);
	}

	/**
	 * Insert element into sorted array.
	 * 
	 * @param a
	 * @param element
	 */
	public static void insertIntoSortedArray(int a[], int element) {
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] > element) {
				a[i + 1] = a[i]; // shift
				printArray(a);
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

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
