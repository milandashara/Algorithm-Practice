package hackerrank.strings;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

public class SpecialFashion {

	String replaceChar(String s) {

		int l = s.length();

		int a = 0;

		char ch;

		String res = "";

		for (int i = 0; i < l; i++) {

			ch = s.charAt(i); // this extracts character one by one

			a = ch + 1; // store ascii value after incrementing 1 to current
						// charcater

			if (ch == 'z' || ch == 'Z') {

				a = a - 26;

			}

			res = res + (char) a;

		}

		return res;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		SpecialFashion ob = new SpecialFashion();

		System.out.print("Enter sentence");

		String s = br.readLine();

		String ans = "";// string variable to store final result

		String word[] = s.split("[. ]+");// saving word of sentence in array
											// using split

		int c = word.length;

		System.out.print("Enter 1st word number");

		int x = Integer.parseInt(br.readLine());

		System.out.print("Enter 2nd word number");

		int y = Integer.parseInt(br.readLine());

		if (x < 1 || y < 1 || x > c || y > c) {

			System.out.println("The number entered is out of range");

		}

		else {

			if (x != y)

			{

				word[y-1] = ob.replaceChar(word[y-1 ]);// sending word to
															// replace char
															// method

			}

			word[x-1] = ob.replaceChar(word[x-1 ]);

			for (int i = 0; i < c; i++) {

				ans = ans + word[i] + " ";

			}

			System.out.println("Output=" + ans.trim() + ".");

		}

	}

}
