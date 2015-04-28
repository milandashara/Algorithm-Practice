package hackerrank.warmup;

import java.util.Scanner;

public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int l=scanner.nextInt();
		int r=scanner.nextInt();
		int max=0;
		for(int i=l;i<=r;i++)
		{
			for(int j=i+1;j<=r;j++){
				int xorValue=i^j;
				if(xorValue>max)
					max=xorValue;
			}
		}
		System.out.println(max);
		
	}
}
