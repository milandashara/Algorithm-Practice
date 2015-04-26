package zenefits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Milan
 *
 */
public class StockMax {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {

				a[j] = scanner.nextInt();

			}

			List<Integer> shares = new ArrayList<Integer>(n);
			long profit = 0;
			int startIndex=0;
			for (int k = 0; k < n ; k++) {
				int maxIndex=maxIndex(a, startIndex);
				
				long buyingPrice=0;
				for(int l=k;l<maxIndex;l++){
					buyingPrice=buyingPrice+a[l];
				}
				long sellingPrice=(long)(maxIndex-(k))*(long)a[maxIndex];
				profit=profit+(sellingPrice-buyingPrice);
//				if (a[k] <= a[a.length-1] || a[k] < a[k+1])// buy share at lower price
//				{
//					shares.add(k);
//				} 
//				 if ( a[k] > a[a.length-1] && a[k] > a[k+1])// sell share at higher price
//				{
////					if (shares.size() > 0) {
////						profit = profit + (a[k] - a[k +1]);
////						shares.remove(new Integer(k - 1));
////					}
//
//					//if (k == n - 2) {
//						// if reached last sell all share and calculate profit
//						int sellingPrice = shares.size() * a[k];
//						int buyingPrice = 0;
//						for (int l = 0; l < shares.size(); l++) {
//							buyingPrice = buyingPrice + a[shares.get(l)];
//							
//						}
//						profit = profit + (sellingPrice - buyingPrice);
//                        shares.clear();
//					//}
//
//				}
				 startIndex=maxIndex+1;
				 k=startIndex-1;
               
			}
			// if reached last sell all share and calculate profit
			//if (a[a.length - 1] > a[a.length - 2]) {
//				int sellingPrice = shares.size() * a[a.length - 1];
//				int buyingPrice = 0;
//				for (int l = 0; l < shares.size(); l++) {
//					buyingPrice = buyingPrice + a[shares.get(l)];
//				}
//				profit = profit + (sellingPrice - buyingPrice);
			//}
			System.out.println(profit);

		}

	}
	
	static int maxIndex(int a[],int start){
		int max=-1;
		int maxIndex=0;
		for(int i=start;i<a.length;i++){
			if(a[i]>max){
				max=a[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}
