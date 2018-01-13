package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {

	static long getWays(long n, long[] coins){
		int[] numCoins = new int[(int)n+1];
		numCoins[0] = 1;
		for(int i = 0; i < coins.length; i++) {
			for(int j = (int)coins[i]; j < numCoins.length; j++) {
				numCoins[j] += numCoins[j - (int)coins[i]];
			}
		}
		return numCoins[(int)n];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[] c = new long[m];
		for(int c_i=0; c_i < m; c_i++){
			c[c_i] = in.nextLong();
		}
		// Print the number of ways of making change for 'n' units using coins having the values given by 'c'
		long ways = getWays(n, c);
		System.out.println(ways);
	}
}