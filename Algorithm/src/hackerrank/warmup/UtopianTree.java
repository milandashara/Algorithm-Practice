package hackerrank.warmup;

import java.util.Scanner;

public class UtopianTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			
			if (n % 2 == 0) {
				double temp = Math.pow(2, n/2);
				System.out.println((long)(2 * temp - 1));
			} else {
				double temp = Math.pow(2, (n + 1)/2);
				System.out.println((long)(2 * temp - 2));
			}

		}
		
		
           
	}
}
