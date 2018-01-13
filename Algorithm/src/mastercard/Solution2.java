package mastercard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mashara on 9/10/17.
 * Simple Queries
 */
public class Solution2 {

	static int[] counts(int[] nums, int[] maxes) {

		int[] maxCount = new int[maxes.length];

		Arrays.sort(nums);

		Map<Integer,Integer> countIndex = new HashMap();



		for (int i=0;i<maxes.length;i++){
			int max = maxes[i];
			int count=0;

			for (int j=countIndex.get(i);j<nums.length;j++){
				if (nums[j] <= max) {
					count++;
					countIndex.put(i,count);
				}else{
					break;
				}
			}

			maxCount[i] = count;
		}

		return maxCount;

	}

	public static void main(String args[]){
//		int nums[] = {1,4,2,4};
//		int maxs[] = {3,5};
//		int maxesCount[] = counts(nums,maxs);
//
//		for (int count:maxesCount){
//			System.out.println(count);
//		}

		int nums1[] = {2,10,5,4,8};
		int maxs1[] = {3,1,7,9};

		int maxesCount[] = counts(nums1,maxs1);

		for (int count:maxesCount){
			System.out.println(count);
		}
	}
}
