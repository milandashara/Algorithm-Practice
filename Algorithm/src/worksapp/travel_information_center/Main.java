package worksapp.travel_information_center;

import java.util.Scanner;

/**
 * 
 * @author Milan
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		// leave 0 index as it is
		TravelInformationCenter tis = new TravelInformationCenter(n + 1);
		for (int i = 1; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			tis.union(a, b);
			if (i == 1) {// set root as festive city
				tis.setFestive(a);
			}
		}

		for (int i = 0; i < m; i++) {// queries
			int q = scanner.nextInt();
			int c = scanner.nextInt();

			// anounce new festive season
			if (q == 1) {
				tis.setFestive(c);
			}// find and print the shortest distance from the city ci to the
				// closest festive city
			else if (q == 2) {
				int distance = tis.findClosestFestiveCityDistance(c);
				System.out.println(distance);
			}
		}

	}

}

/**
 * 
 * @author Milan
 *
 */

class TravelInformationCenter {
	private int[] id;
	private boolean[] isFestive;

	public void setFestive(int i) {
		isFestive[i] = true;
	}

	public TravelInformationCenter(int N) {
		id = new int[N];
		isFestive = new boolean[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			isFestive[i] = false;
		}
	}

	public void union(int p, int q) {
		id[q] = p;
	}

	public int findClosestFestiveCityDistance(int c) {

		int distance = 0;

		while (!isFestive[c] && c != id[c]) {
			c = id[c];
			distance++;
		}
		return distance;
	}

}
