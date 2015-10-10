package zenefits;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RankOfWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			String str = scanner.next();

			System.out.println(solution1(str));
			//allPermutationList.clear();
		}
	}

	static Set<String> allPermutationList = new HashSet<String>();
	static int rank = 0;
	static boolean found = false;

	
	
	
	private static long solution2(String str){
//		int n = str.length(); 
//		int rank = 0; 
//		for (int i = 0; i < n-1; i++) { 
//		int x=0; 
//		for (int j = i+1; j<n ; j++) { 
//		if (str.charAt(i) > str.charAt(j)) 
//		x++; 
//		} 
//		rank = rank+ x*(factorial(n-i-1));
//		} 
//
//		return rank;
		
//		for(int i=0;i<str.length();i++){
//		      rank += (str[input[i] - 'a']-1)*(factorial(N-i-1));
//		//Update the rank of all those characters which are higher in rank than the present.
//		      for(int j=i+1;j<N;j++){
//		          if(input[j]>=input[i]) str[input[j]-'a']--;
//		      }
//		}
		
		long count = 0;
	    long suffixPermCount = 1;
	    java.util.Map<Character, Integer> charCounts =
	        new java.util.HashMap<Character, Integer>();
	    for (int i = str.length() - 1; i > -1; i--) {
	        char x = str.charAt(i);
	        int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
	        charCounts.put(x, xCount);
	        for (java.util.Map.Entry<Character, Integer> e : charCounts.entrySet()) {
	            if (e.getKey() < x) {
	                count += suffixPermCount * e.getValue() / xCount;
	            }
	        }
	        suffixPermCount *= str.length() - i;
	        suffixPermCount /= xCount;
	    }
	    return count;
	}
	
	 public static int factorial(int n) {
	        int fact = 1; // this  will be the result
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }
	
	private static int solution1(String s) {
		 rank = 0;
		 found=false;
		 allPermutationList=new HashSet<String>();
		char c[] = s.toCharArray();
		Arrays.sort(c);
		String sorted = new String(c);
		if (s.equals(sorted))
			return 0;
		permutation("", sorted, s);
		return rank;

		// int i = 0;
		// for (String str : allPermutationList) {
		// if (str.contains(s)) {
		// return i;
		// }
		// i++;
		// }
		// return -1;

	}

	/**
	 * Find all permutation of String time complexity = n*n!
	 * 
	 * @param prefix
	 * @param str
	 */
	private static void permutation(String prefix, String str, String orignal) {
		int n = str.length();
		if (n == 1) {
			//System.out.println(prefix + str);
			
			if ((prefix + str).equals(orignal)) {
				found = true;
			
				// return rank;
			} else if(!allPermutationList.contains(prefix + str)){
				rank++;
				}
			
			 allPermutationList.add(prefix + str);
		} else {
			for (int i = 0; i < n; i++) {
				String temp = str.substring(0, i) + str.substring(i + 1);
				if (found)
					break;

				permutation(prefix + str.charAt(i), temp, orignal);

			}
		}

	}

	static int[] get_ranks(String[] words) {
		int a[] = new int[words.length];
		for (int i = 0; i < words.length; i++) {

			a[i] = solution1(words[i]);
			//allPermutationList.clear();
		}
		return a;

	}
}
