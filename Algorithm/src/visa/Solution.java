package visa;

/**
 * Created by mashara on 5/11/17.
 */
public class Solution {
	static String longestEvenWord(String sentence) {
		String words[]=sentence.split("\\s");

		int maxEvenLength = 0;
		int maxEvenLengthIndex = -1;

		for (int i=0;i<words.length;i++){
			String word = words[i];
			if (maxEvenLength < word.length() && word.length() % 2 == 0){
				maxEvenLength = word.length();
				maxEvenLengthIndex = i;
			}
		}
		if (maxEvenLengthIndex == -1){
			return "00";
		}
		else
			return words[maxEvenLengthIndex];
	}

	public static void main(String a[]){
//		System.out.println(longestEvenWord("hey"));
//		System.out.println(lastLetters("APPLE"));
//		fizzBuzz(15);
		System.out.println(consecutive1(10));
	}

	static String lastLetters(String word) {
			return word.charAt(word.length()-1) + " "+ word.charAt(word.length() -2);
	}

	static void fizzBuzz(int n) {
		for (int i=1;i<=n;i++){
			if (i % 15 ==0){
				System.out.println("FizzBuzz");
			}else if (i % 3 ==0 && i % 5 !=0){
				System.out.println("Fizz");
			}else if (i % 5 ==0 && i % 3 !=0){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
		}
	}

	int addNumbers(float a, float b) {
		return (int)Math.floor(a+b);
	}

	static int consecutive(long num) {
		int count = 0;
		for (int L = 1; L * (L + 1) < 2 * num; L++)
		{
			float a = (float) ((1.0 * num-(L * (L + 1)) / 2) / (L + 1));
			if (a-(int)a == 0.0)
				count++;
		}
		return count;
	}

	static int consecutive1(long num) {
		int count = 0;
		for (int L = 1; L * (L + 1) < 2 * num; L++)
		{
			//float a = (float) ((1.0 * num-(L * (L + 1)) / 2) / (L + 1));
			float a =num -((num - L)*(num+ L -1)/2);
			if (a ==0.0)
				count++;
		}
		return count;
	}
}
