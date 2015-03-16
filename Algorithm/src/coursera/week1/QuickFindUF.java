package coursera.week1;

/**
 * 
 * Dynamic Connectivity 
 * IsConnected :Is there point P and Q are Connected.
 * Union : connect two points
 * 
 * @author Milan
 *
 */
public class QuickFindUF {
	
	private int[] id;
	
	/**
	 * Initialize N connected components
	 * O(n)
	 * @param n
	 */
	public QuickFindUF(int n){
		id=new int[n];
		for(int i=0;i<n;i++)
			id[i]=i;
	}
	
	/**
	 * Check if p and q are in same components
	 * 2 array access
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isConnected(int p,int q){
		return id[p]==id[q];
	}
	
	/**
	 * Merge two components
	 * 
	 * Change all the with id[p] to id[q]
	 * 2n+2 array access. 
	 * union is Too slow. N*N array access to union N Objects
	 * @param p
	 * @param q
	 */
	public void union(int p,int q){
		int pid=id[p];
		int qid=id[q];
		
		for(int i=0;i<id.length;i++){
			if(id[i]==pid)
				id[i]=qid;
		}
	}
	
	public static void main(String[] args) {
		QuickFindUF quickFindUF=new QuickFindUF(5);
		quickFindUF.union(0, 1);
		System.out.println(quickFindUF.isConnected(0, 1));
		quickFindUF.union(1, 2);
		System.out.println(quickFindUF.isConnected(0, 2));
		System.out.println(quickFindUF.isConnected(0, 4));
		quickFindUF.union(2, 4);
		System.out.println(quickFindUF.isConnected(0, 4));
	}

}
