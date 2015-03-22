package hackerrank;

/**
 * 
 * @author Milan
 * 
 * n=0 to 3
 * sum=1+2+4+8=15 =(2pow(n+1)-1)
 *
 */
public class SumOfPowerOf2 {
	
	public static void main(String[] args) {
		int n=3;
		System.out.println((int)sumOfPowerOf2(n));
		System.out.println((int)sumOfPowerOf2UsingBitWise(n));
		
	}
	
	public static double sumOfPowerOf2(int n){
		return Math.pow(2, n) - 1;
	}
	
	/**
	 * Using bitwise
	 * @param n
	 * @return
	 */
	public static long sumOfPowerOf2UsingBitWise(int n){
		int i=1;
		long sum=0;
		int cnt=0;

		while (cnt < n) {
			
			sum += i;
			i = i << 1;
			cnt++;
		}
		return sum;
	}

}
