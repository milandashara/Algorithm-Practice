package hackerrank.strings;

import java.util.Scanner;

/**
 * 
 * @author Milan
 *https://www.hackerrank.com/challenges/anagram
 */
public class Anagram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			String s = in.next();
			char charArray[] = s.toCharArray();

			if (charArray.length % 2 != 0) {
				System.out.println(-1);
			} else {
				int count = 0;
				for (int j = 0; j < (charArray.length / 2); j++) {
					boolean flag = true;
					for (int k = (charArray.length / 2); k < charArray.length; k++) {
						if (charArray[j] == charArray[k]) {
							flag = false;
							charArray[k] = ' ';
							// char value=charArray[k];
							// charArray[k]=charArray[charArray.length-j-1];
							// charArray[charArray.length-j-1]=value;
							break;
						}
					}
					if (flag) {
						count++;
					}

				}

				System.out.println(count);
			}
		}
		in.close();
	}
}
