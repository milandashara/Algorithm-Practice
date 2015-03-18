package coursera.week1;

/**
 * Make every other node in path point to its
 * grandparent (thereby halving path length).
 * 
 * Application : 
 * Percolation.
 * Games (Go, Hex).
 * Dynamic connectivity.
 * east common ancestor.
 * Equivalence of finite state automata.
 * Hoshen-Kopelman algorithm in physics.
 * Hinley-Milner polymorphic type inference.
 * Kruskal's minimum spanning tree algorithm.
 * Compiling equivalence statements in Fortran.
 * Morphological attribute openings and closings.
 * Matlab's bwlabel() function in image processing.
 * 
 * @author Milan
 *
 */
public class WeightedQuickUnionPathCompressionUF {
	private int[] id;
	private int[] sz;

	public WeightedQuickUnionPathCompressionUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++){
			id[i] = i;
			sz[i]=1;
		}
		
	}

	private int root(int i) {
		while (i != id[i]){
			id[i] = id[id[i]];//single line change
			i = id[i];
		}
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
		WeightedQuickUnionPathCompressionUF weightedQuickUnionPathCompressionUF=new WeightedQuickUnionPathCompressionUF(5);
		weightedQuickUnionPathCompressionUF.union(0, 1);
		System.out.println(weightedQuickUnionPathCompressionUF.isConnected(0, 1));
		weightedQuickUnionPathCompressionUF.union(1, 2);
		System.out.println(weightedQuickUnionPathCompressionUF.isConnected(0, 2));
		System.out.println(weightedQuickUnionPathCompressionUF.isConnected(0, 4));
		weightedQuickUnionPathCompressionUF.union(2, 4);
		System.out.println(weightedQuickUnionPathCompressionUF.isConnected(0, 4));
	}
}
