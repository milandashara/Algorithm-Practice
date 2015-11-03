package palantir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = 0;
		int n = 0;

		m = in.nextInt();
		n = in.nextInt();
		char[][] input = new char[m][n];
		for (int i = 0; i < m; i++) {
			String line = in.next().trim();
			char[] row = line.toCharArray();
			input[i] = row;
		}
		int maxWishes = findMaxWishes(input, m, n);
		System.out.println(maxWishes);

	}

	/**
	 * Find Max Wishes that can be granted
	 * 
	 * @param input
	 * @return
	 */
	public static int findMaxWishes(char[][] input, int m, int n) {
		Map<String, Integer> flipColumnsWishesCount = new HashMap<String, Integer>();
		// int[] wishCountArray = new int[(n+1) * 10];
		for (int i = 0; i < input.length; i++) {
			List<Integer> pColumnIndexes = getPColumnindexes(i, input);
			List<Integer> tColumnIndexes = getTColumnindexes(i, input);

			String pColumnIndexKey = generateColumnKey(pColumnIndexes);
			String tColumnIndexKey = generateColumnKey(tColumnIndexes);
			// int wishCount =
			// wishCountArray[Integer.parseInt(pColumnIndexKey)];
			// wishCount++;
			// wishCountArray[Integer.parseInt(pColumnIndexKey)] = wishCount;
			//
			// wishCount = wishCountArray[Integer.parseInt(tColumnIndexKey)];
			// wishCount++;
			// wishCountArray[Integer.parseInt(tColumnIndexKey)] = wishCount;

			flipColumnsWishesCount = updateWishesCount(flipColumnsWishesCount,
					pColumnIndexKey);
			flipColumnsWishesCount = updateWishesCount(flipColumnsWishesCount,
					tColumnIndexKey);

		}

		int maxWishes = -1;
		for (Map.Entry<String, Integer> entry : flipColumnsWishesCount
				.entrySet()) {

			int wishes = entry.getValue();
			if (wishes > maxWishes) {
				maxWishes = wishes;
			}
			// System.out.println(entry.getKey());
			// System.out.println("wishes:" +wishes);

		}

		// for (int i = 0; i < wishCountArray.length; i++) {
		// int wishes = wishCountArray[i];
		// if (wishes > maxWishes) {
		// maxWishes = wishes;
		// }
		// }

		return maxWishes;

	}

	/**
	 * Increment Wish count
	 * 
	 * @param flipColumnsWishesCount
	 * @param key
	 * @return
	 */
	public static Map<String, Integer> updateWishesCount(
			Map<String, Integer> flipColumnsWishesCount, String key) {
		if (flipColumnsWishesCount.containsKey(key)) {
			int wishesCount = flipColumnsWishesCount.get(key);
			wishesCount++;
			flipColumnsWishesCount.put(key, wishesCount);
		} else {
			boolean isContainAll = false;
			boolean isInserted = false;
			String[] columnIndexes = key.split("_");
			for (Map.Entry<String, Integer> entry : flipColumnsWishesCount
					.entrySet()) {

				for (String columnIndex : columnIndexes) {
					if (entry.getKey().contains(columnIndex)) {
						isContainAll = true;
					} else {
						isContainAll = false;
						break;
						
					}

				}

				if (isContainAll) {
					Integer wishesCount = flipColumnsWishesCount.get(entry
							.getKey());
					wishesCount++;
					flipColumnsWishesCount.put(entry.getKey(), wishesCount);
					isContainAll = false;
					isInserted = true;
				}
			}
			if (!isInserted)
				flipColumnsWishesCount.put(key, 1);
		}

		return flipColumnsWishesCount;
	}

	/**
	 * Key is list of column indexes fliping which will result in wish granted
	 * 
	 * @param columnIndexes
	 * @return
	 */
	public static String generateColumnKey(List<Integer> columnIndexes) {
		String key = "";
		for (int i = 0; i < columnIndexes.size(); i++) {
			if (key.equals(""))
				key = key + columnIndexes.get(i).toString();
			else
				key = key + "_" + columnIndexes.get(i).toString();
		}
		return key;
	}

	/**
	 * Get Column Indexs containing value as 'P' for a row
	 * 
	 * @param row
	 * @param input
	 * @return
	 */
	public static List<Integer> getPColumnindexes(int row, char[][] input) {
		char[] columnValue = input[row];
		List<Integer> pColumnIndexs = new ArrayList<Integer>();
		for (int i = 0; i < columnValue.length; i++) {
			if (columnValue[i] == 'P') {
				pColumnIndexs.add(i);
			}
		}
		return pColumnIndexs;
	}

	/**
	 * Get Column Indexs containing value as 'T' for a row
	 * 
	 * @param row
	 * @param input
	 * @return
	 */
	public static List<Integer> getTColumnindexes(int row, char[][] input) {
		char[] columnValue = input[row];
		List<Integer> tColumnIndexs = new ArrayList<Integer>();
		for (int i = 0; i < columnValue.length; i++) {
			if (columnValue[i] == 'T') {
				tColumnIndexs.add(i);
			}
		}
		return tColumnIndexs;
	}

}
