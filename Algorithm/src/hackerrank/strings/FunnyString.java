package hackerrank.strings;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/funny-string
 * @author Milan
 *
 */
public class FunnyString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			String s = in.next();
			char charArray[]=s.toCharArray();
			boolean flag=true;
			for(int j=0;j<(charArray.length/2)+1;j=j+2){
				if(Math.abs(((int)charArray[j+1]-(int)charArray[j])) != Math.abs(((int)charArray[charArray.length-j-2]-(int)charArray[charArray.length-j-1]))){
					flag=false;
					break;
				}
			}
			if(flag){
				System.out.println("Funny");
			}else{
				System.out.println("Not Funny");
			}
			
		}
		
	}
}
