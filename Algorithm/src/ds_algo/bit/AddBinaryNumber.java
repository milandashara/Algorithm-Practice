package ds_algo.bit;

public class AddBinaryNumber {

	public static int sum(String a,String b){

		// Use as radix 2 because it's binary
		int number0 = Integer.parseInt(a, 2);
		int number1 = Integer.parseInt(b, 2);

		return number0 + number1;
	}

	public static int sumBinary(String a,String b){

		int la = a.length();
		int lb = b.length();

		int max = Math.max(la, lb);

		StringBuilder sum = new StringBuilder("");
		int carry = 0;

		for(int i = 0; i < max; i++){
			int m = getBit(a, la - i - 1);
			int n = getBit(b, lb - i - 1);
			int add = m + n + carry;
			sum.append(add % 2);
			carry = add / 2;
		}

		if(carry == 1)
			sum.append("1");

		return Integer.parseInt(sum.reverse().toString());
	}

	public static int getBit(String s, int index){
		if(index < 0 || index >= s.length())
			return 0;

		if(s.charAt(index) == '0')
			return 0;
		else
			return 1;

	}


}
