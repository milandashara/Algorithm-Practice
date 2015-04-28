package zenefits;

import java.util.Scanner;

/**
 * 
 * @author Milan
 *
 */
public class GoodNodes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		int count = 0;

		for (int i = 0; i < n; i++) {

			int value = a[i];
			while (a[value - 1] != value && a[value - 1] != 1)
				value = a[value - 1];

			if (a[value - 1] == value && a[value - 1] != 1) {
				a[value - 1] = 1;
				count++;
			}
		}

		System.out.println(count);
	}
}
