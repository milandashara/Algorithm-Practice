package string;

import java.util.Arrays;

/**
 * 
 * @author Milan D Ashara
 * 
 */
public class Anagram {

	/**
	 * Find all permutation of String
	 * time complexity = n*n!
	 * @param prefix
	 * @param str
	 */
	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 1)
			System.out.println(prefix+str);
		else {
			for (int i = 0; i < n; i++) {
				System.out.println("permutation(" + prefix + str.charAt(i)
						+ ", " + str.substring(0, i) + str.substring(i + 1)
						+ ")");
				/**
				 * str.charAt(i) = gets char at position i
				 * str.substring(0, i) + str.substring(i + 1) = gets charcter before and after i
				 */
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1));

			}
		}
	}

	/**
	 * Check if two String are anagram of each other using sort
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static boolean isAnagram1(String str1, String str2) {

		// If string lengths are not same, the strings are not anagrams.
		if (str1.length() != str2.length()) {
			return false;
		}

		// Sort characters of both the strings.
		str1 = sortCharacters(str1);
		str2 = sortCharacters(str2);

		// After sorting if strings are equal then they are anagrams.
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}

	/**
	 * Check if two String are anagram of each other using iterative comparison
	 * of characters
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static boolean isAnagram2(String str1, String str2) {
		// If length of strings are not same, the strings are not anagrams.
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		char[] str1Chars = str1.toLowerCase().toCharArray();
		StringBuilder builder = new StringBuilder(str2.toLowerCase());

		for (Character ch : str1Chars) {

			// Find the index of the current character in builder.
			int index = builder.indexOf(String.valueOf(ch));
			if (index == -1) {
				return false;
			}
			// Remove the character from builder so that multiple occurrences of
			// a character in the first string will be matched with equal number
			// of occurrences of the character in the second string.
			builder.delete(index, index + 1);
		}
		return true;
	}

	/**
	 * Helper method to sort characters
	 * 
	 * @param str
	 * @return
	 */
	private static String sortCharacters(String str) {
		char[] charArray = str.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		permutation("", "ABCD");
	}

}
