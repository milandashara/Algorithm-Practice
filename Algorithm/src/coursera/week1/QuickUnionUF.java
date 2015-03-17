package coursera.week1;

/**
 * 
 * @author Milan
 * Data structure.
 * 1.Integer array id[] of length N.
 * 2.Interpretation: id[i] is parent of i.
 * 3.Root of i is id[id[id[...id[i]...]]].
 * 
 * When tree gets tall. find is too expensive. 
 * 
 * Improvements: Modify quick union to avoid tall trees
 * 
 * Worst case : 
 * Find : N
 * Union : N
 *
 */
public class QuickUnionUF {
	private int[] id;

	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public static void main(String[] args) {
		QuickUnionUF quickUnionUF=new QuickUnionUF(5);
		quickUnionUF.union(0, 1);
		System.out.println(quickUnionUF.isConnected(0, 1));
		quickUnionUF.union(1, 2);
		System.out.println(quickUnionUF.isConnected(0, 2));
		System.out.println(quickUnionUF.isConnected(0, 4));
		quickUnionUF.union(2, 4);
		System.out.println(quickUnionUF.isConnected(0, 4));
	}
}
