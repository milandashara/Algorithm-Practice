package coursera.week1;

/**
 * Find: takes time proportional to depth of p and q(log n).
 * Union: takes constant time, given roots.
 * 
 * Increased Cost of size array.
 * @author Milan
 *
 */
public class WeightedQuickUnionUF {

	private int[] id;
	private int[] sz;

	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++){
			id[i] = i;
			sz[i]=1;
		}
		
	}

	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	/*
	 * takes log n time
	 */
	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * Improved Performance code. takes log n time
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		 int i = root(p);
		 int j = root(q);
		 if (i == j) return;
		 if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		 else { id[j] = i; sz[i] += sz[j]; } 
	}
	
	public static void main(String[] args) {
		WeightedQuickUnionUF weightedQuickUnionUF=new WeightedQuickUnionUF(5);
		weightedQuickUnionUF.union(0, 1);
		System.out.println(weightedQuickUnionUF.isConnected(0, 1));
		weightedQuickUnionUF.union(1, 2);
		System.out.println(weightedQuickUnionUF.isConnected(0, 2));
		System.out.println(weightedQuickUnionUF.isConnected(0, 4));
		weightedQuickUnionUF.union(2, 4);
		System.out.println(weightedQuickUnionUF.isConnected(0, 4));
	}
}
