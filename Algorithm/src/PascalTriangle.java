/**
 * 
 * @author Vijay
 *
 */

public class PascalTriangle {

	public static void main(String[] args) {

		pascalTriangle(10);

	}

	/**
	 * Print pascal triangle
	 * @param k
	 */
	public static void pascalTriangle(int k) {

		for (int i = 0; i < k; i++) {

			int number = 1;

			for (int j = 0; j <= i; j++) {

				System.out.format("%4d", number);

				number = number * (i - j) / (j + 1);

			}

			System.out.println();

		}
	}

}
