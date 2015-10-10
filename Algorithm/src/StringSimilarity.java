import java.util.Scanner;

/**
 * 
 * @author Vijay
 *
 */
public class StringSimilarity {
	
	/**
	 * find String Similarity
	 * @param str
	 * @return
	 */
	public static int stringSimilarity(String str) {
		char[] charArr = str.toCharArray();
		int length = charArr.length;
		int sum = length;
		for (int i = 1; i < length; i++) {
			int similarity = 0;
			for (; similarity < length - i; similarity++)
				if (charArr[similarity] != charArr[similarity + i]) {
					break;
				}
			sum += similarity;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			System.out.println(stringSimilarity(s));
		}
	}
}