package thoughtWorks;

import java.util.LinkedList;
import java.util.List;

public class Solution {


	public static void main(String a[]){
		//System.out.println(solve(2));
	//	System.out.println(solve(3));
		System.out.println(solve(4));
		System.out.println(solve(5));
		System.out.println(solve(6));
		System.out.println(solve(8));
		System.out.println(solve(10));
	}

	static long solve(long n){
		// Write your code here
		if (n==2){
			return 2;
		}

		if (n==4){
			return 4;
		}


		//init
		List<Long> cards = new LinkedList<>();
		for(long i=0;i<n;i++){
			cards.add(i+1);
		}

		int size = cards.size();
		while(size != 1){

			int orignalSize = size;
			//get odd index element
			List<Long> oddIndexCards = getOddIndex(cards);

			//remove even index card
			cards = remoteEvenIndexCards(cards);

			size = cards.size();
			if (size==1)
				break;

			int temp = size;
			//if (orignalSize%2 !=0)//keep last element
			{
					temp--;
			}

			for(int i=0;i<temp;i++){
				cards.remove(i);
				cards.add(oddIndexCards.get(i));//append oddIndexCards to back of cards
			}
			size = cards.size();
			//append oddIndexCards to back of cards
//			for(int i=0;i<oddIndexCards.size();i++){
//
//			}




		}

		return cards.get(0);

	}

	public static List<Long> getOddIndex(List<Long> cards){
		int n = cards.size();
		if(n%2 != 0){ // don't return last
			n--;
		}

		List<Long> oddIndexCards = new LinkedList<>();

		for (int i=0;i<n;i++){
			if (i%2 != 0){
				oddIndexCards.add(cards.get(i));
			}
		}

		return oddIndexCards;
	}

	public static List<Long> remoteEvenIndexCards(List<Long> cards){


		int n = cards.size();
		List<Long> cardsToRemote = new LinkedList();

		if (n%2!=0)
		{
			n--;
		}

		for (int i=0;i<n;i++){
			if (i%2 == 0){
				cardsToRemote.add(cards.get(i));
			}
		}

		n = cardsToRemote.size();
		for(int i=0;i<n;i++){
			cards.remove(cardsToRemote.get(i));
		}

		return cards;
	}


}
