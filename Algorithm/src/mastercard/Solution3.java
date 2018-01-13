package mastercard;

import java.util.Arrays;

/**
 * Created by mashara on 9/10/17.
 * Cutting surplus metal
 */
public class Solution3 {

	static int maxProfit(int costPerCut, int salePrice, int[] lengths) {
		int saleLength = 0;
		if (salePrice >= costPerCut)
		 saleLength = (salePrice/2) + 1;
		else {
				saleLength = (costPerCut/2) + 1;
		}
		int totalCuts = 0;
		int totalUniformRods=0;
		for (int i=0;i<lengths.length;i++){
			if (lengths[i] < saleLength){
				continue;
			}else {
				totalCuts = totalCuts + (lengths[i] / saleLength);
//				totalUniformRods = totalUniformRods + (lengths[i] / saleLength);
//				if ((lengths[i] % saleLength) != 0) {
//					totalCuts++;
//				}
			}
		}
		totalUniformRods = totalCuts;
		int totalProfit = (totalUniformRods*salePrice*saleLength) - (totalCuts * costPerCut);
		return totalProfit;
	}

	public static void main(String args[]){
		int lengths[] = {26,103,59};
		System.out.println(maxProfit(100,10,lengths));
	}
}
