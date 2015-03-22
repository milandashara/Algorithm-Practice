package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Question:
 * 
 * http://www.careercup.com/question?id=4891677221191680
 * @author Milan
 *
 */
public class BinaryTreeUsingArrayList {

	private String[] array;
	private HashMap<Integer, List<String>> map=new HashMap<Integer, List<String>>();
	
	int height=0;

	public BinaryTreeUsingArrayList(int size) {
		array = new String[size];
	}

	private int current = 1;
	

	public void addRoot(String rootStr) {
		array[current] = rootStr;
		
	}

	public void addChild(int parentIndex, String child) {
		if (array[2 * parentIndex ] == null){
			array[2 * parentIndex ] = child;
			height++;
		}
		else
			array[2 * parentIndex+1 ] = child;
		 current++;
	}

	public void addChild(String child) {
		if (array[2 * current ] == null)
			array[2 * current ] = child;
		else
			array[2 * current ] = child;
		current++;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine().trim();
		int size = Integer.parseInt(firstLine);
		BinaryTreeUsingArrayList binaryTreeUsingArrayList = new BinaryTreeUsingArrayList(
				((int)Math.pow(2, size))+size);
		
		//create binary tree
		while (binaryTreeUsingArrayList.current != size) {
			String line = in.nextLine();
			String s[] = line.split(" ");
			if (binaryTreeUsingArrayList.current == 1) {
				binaryTreeUsingArrayList.addRoot(s[0]);
			}  {
				int parent =binaryTreeUsingArrayList.contains(s[0]);
				if (parent != -1) {
					if (s.length == 2) {
					
						binaryTreeUsingArrayList.addChild(parent,s[1]);
					}

				} else {

				}
			}

		}
		
		//print in Bread First Search
		System.out.println(binaryTreeUsingArrayList.array[1]);
		
		
		for(int i=1;i<=binaryTreeUsingArrayList.height;i++){
			int numOfChild=(int)Math.pow(2, i);
			
			String s="";
			for(int j=0;j<numOfChild;j++){
				if(binaryTreeUsingArrayList.array[numOfChild+j] !=null){
				s=s+binaryTreeUsingArrayList.array[numOfChild+j]+" ";
				
				}
				
			}
			
			
			System.out.println(s);
		}

	}

	public int contains(String s2) {
		for (int i = 0; i < array.length; i++) {
			if (s2.equals(array[i]))
				return i;
		}
		return -1;
	}
	
	
	

}
