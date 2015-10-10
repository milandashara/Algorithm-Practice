package zenefits;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author Milan
 *
 */
public class SellTicket {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n,
				Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			pq.add(scanner.nextInt());
		}

		int maxMoneyEarned = 0;

		while (m > 0 && !pq.isEmpty()) {
			int maxWindow = pq.remove();
			maxMoneyEarned += maxWindow;
			maxWindow--;
			if (maxWindow > 0)
				pq.add(maxWindow);
			m--;
		}
		System.out.println(maxMoneyEarned);
		scanner.close();

	}

}
