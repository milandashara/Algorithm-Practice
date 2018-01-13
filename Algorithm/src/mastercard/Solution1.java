package mastercard;

import java.util.HashMap;

/**
 * Created by mashara on 9/10/17.
 * Modify prices
 */
public class Solution1 {

	static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {

		HashMap hashMap = new HashMap();
		for (int i=0;i<origItems.length;i++){
			hashMap.put(origItems[i],origPrices[i]);
		}
		int count = 0;
		for (int j=0;j<items.length;j++){

			float orignalPrice = (float)hashMap.get(items[j]);
			float salePrice = prices[j];

			if (orignalPrice != salePrice){
				count++;
			}

		}

		return count;

	}
}
