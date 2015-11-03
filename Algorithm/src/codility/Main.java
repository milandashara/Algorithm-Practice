package codility;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		int A[] = { 1, 4, 5 };
		System.out.println(solution2(A));
	}

	public int solution(int A, int B) {
		String aStr = "" + A;
		String bStr = "" + B;

		int sum_lenght = aStr.length() + bStr.length();

		if (sum_lenght > 9) {
			return -1;
		}

		int max_length = 0;
		if (aStr.length() > bStr.length()) {
			max_length = aStr.length();
		} else if (aStr.length() < bStr.length()) {
			max_length = bStr.length();
		} else
			max_length = aStr.length();

		String cStr = "";
		for (int i = 0; i < max_length; i++) {
			if (i < aStr.length())
				cStr = cStr + aStr.charAt(i);
			if (i < bStr.length())
				cStr = cStr + bStr.charAt(i);
		}

		int c = Integer.parseInt(cStr);
		if (c > 100000000)
			return -1;
		else
			return c;
	}

	public int solution1(int K, int[] A) {
		// int count = 0;
		// for (int i = 0; i < A.length; i++) {
		// for (int j = i; j < A.length; j++) {
		// if (A[i] + A[j] == K)
		// if (i != j)
		// count += 2;
		// else if (i == j)
		// count++;
		//
		// }
		// }

		Map<Long, Integer> complementValueCounter = new HashMap<Long, Integer>();
		for (int i = 0; i < A.length; i++) {
			final long complementValue = ((long) K) - A[i];
			if(complementValueCounter.containsKey(complementValue)){
				int complementValueCount=complementValueCounter.get(complementValue);
				complementValueCount++;
				complementValueCounter.put(complementValue, complementValueCount);
			}
			else{
				complementValueCounter.put(complementValue, 1);
			}
		}

		int count = 0;
		for (int i = 0; i < A.length; i++) {
			final long value = A[i];
			count += complementValueCounter.containsKey(value) ? complementValueCounter.get(value) : 0;
		}
		return count;
	}

	public static int solution2(int[] A) {
		Double K = 0.0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0)
				K = Math.pow(2, A[0]);
			else
				K = 2 * K + Math.pow(2, A[i] - A[i - 1]);
		}
		K = 3 * K;
		return Long.bitCount(K.longValue());
	}
}
