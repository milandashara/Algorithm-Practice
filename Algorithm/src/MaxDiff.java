import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Vijay
 *
 */
public class MaxDiff {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr.add(in.nextInt());
		}
		System.out.println(maxdiff(arr));

	}

	public static int maxdiff(List<Integer> arr) {
		int max = -1;
		int maxdiff = 0;

		for (int i = arr.size() - 1; i >= 0; i--) {
			if (max < arr.get(i))
				max = arr.get(i);
			int diff = max - arr.get(i);
			if (maxdiff < diff)
				maxdiff = diff;
		}

		return maxdiff;
	}
}
