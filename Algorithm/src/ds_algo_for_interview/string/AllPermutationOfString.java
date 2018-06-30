package ds_algo_for_interview.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Print all permutation of String
 */
public class AllPermutationOfString {

	public static void main(String a[]){
		System.out.println("\nPermutations for " + "abc" + " are: \n" + permute("abc"));
	}

	public static Set<String> permute(String s){
		Set<String> perm = new HashSet<>();

		if (s == null){
			return null;
		}else if (s.length() == 0){
			perm.add("");
			return perm;
		}

		//get initial char
		char initial = s.charAt(0);
		String rem = s.substring(1);
		Set<String> words = permute(rem);
		for (String word:words){
			for (int i = 0; i <= word.length(); i++){
				perm.add(word.substring(0,i) + initial + word.substring(i));
			}
		}

		return perm;
	}
}
