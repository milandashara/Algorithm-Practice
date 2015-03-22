package hackerrank;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 * Sample input: 

	8 
	16 
	4 5 0.35 
	4 7 0.37 
	5 7 0.28 
	0 7 0.16 
	1 5 0.32 
	0 4 0.38 
	2 3 0.17 
	1 7 0.19 
	0 2 0.26 
	1 2 0.36 
	1 3 0.29 
	2 7 0.34 
	6 2 0.40 
	3 6 0.52 
	6 0 0.58 
	6 4 0.93 
 * 
 * @author Milan
 *
 */
public class KruskalMST {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		KruskalMST mst = new KruskalMST();
		mst.createEdgeWeightedGraph(in);
		mst.runKruskalAlgorithm();
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.printf("%.5f\n", mst.weight());
	}

	public void createEdgeWeightedGraph(Scanner in) {
		this.G = new EdgeWeightedGraph(in);
	}

	private double weight; // weight of MST
	private Queue<Edge> mst = new Queue<Edge>(); // edges in MST
	private EdgeWeightedGraph G;

	public KruskalMST() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
	 * 
	 * 
	 */

	public void runKruskalAlgorithm() {
		// more efficient to build heap by passing array of edges
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}

		// run greedy algorithm
		UF uf = new UF(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w)) { // v-w does not create a cycle
				uf.union(v, w); // merge v and w components
				mst.enqueue(e); // add edge e to mst
				weight += e.weight();
			}
		}

		
	}

	/**
	 * Returns the edges in a minimum spanning tree (or forest).
	 * 
	 * @return the edges in a minimum spanning tree (or forest) as an iterable
	 *         of edges
	 */
	public Iterable<Edge> edges() {
		return mst;
	}

	/**
	 * Returns the sum of the edge weights in a minimum spanning tree (or
	 * forest).
	 * 
	 * @return the sum of the edge weights in a minimum spanning tree (or
	 *         forest)
	 */
	public double weight() {
		return weight;
	}

	
	class EdgeWeightedGraph {
		private final int V;
		private int E;
		private Bag<Edge>[] adj;

		/**
		 * Initializes an empty edge-weighted graph with <tt>V</tt> vertices and
		 * 0 edges. param V the number of vertices
		 * 
		 * @throws java.lang.IllegalArgumentException
		 *             if <tt>V</tt> < 0
		 */
		public EdgeWeightedGraph(int V) {
			if (V < 0)
				throw new IllegalArgumentException(
						"Number of vertices must be nonnegative");
			this.V = V;
			this.E = 0;
			adj = (Bag<Edge>[]) new Bag[V];
			for (int v = 0; v < V; v++) {
				adj[v] = new Bag<Edge>();
			}
		}

		/**
		 * Initializes a random edge-weighted graph with <tt>V</tt> vertices and
		 * <em>E</em> edges. param V the number of vertices param E the number
		 * of edges
		 * 
		 * @throws java.lang.IllegalArgumentException
		 *             if <tt>V</tt> < 0
		 * @throws java.lang.IllegalArgumentException
		 *             if <tt>E</tt> < 0
		 */
		public EdgeWeightedGraph(int V, int E) {
			this(V);
			if (E < 0)
				throw new IllegalArgumentException(
						"Number of edges must be nonnegative");
			for (int i = 0; i < E; i++) {
				int v = (int) (Math.random() * V);
				int w = (int) (Math.random() * V);
				double weight = Math.round(100 * Math.random()) / 100.0;
				Edge e = new Edge(v, w, weight);
				addEdge(e);
			}
		}

		/**
		 * Initializes an edge-weighted graph from an input stream. The format
		 * is the number of vertices <em>V</em>, followed by the number of edges
		 * <em>E</em>, followed by <em>E</em> pairs of vertices and edge
		 * weights, with each entry separated by whitespace.
		 * 
		 * @param in
		 *            the input stream
		 * @throws java.lang.IndexOutOfBoundsException
		 *             if the endpoints of any edge are not in prescribed range
		 * @throws java.lang.IllegalArgumentException
		 *             if the number of vertices or edges is negative
		 */
		public EdgeWeightedGraph(Scanner in) {
			this(in.nextInt());
			int E = in.nextInt();
			if (E < 0)
				throw new IllegalArgumentException(
						"Number of edges must be nonnegative");
			for (int i = 0; i < E; i++) {
				int v = in.nextInt();
				int w = in.nextInt();
				double weight = in.nextDouble();
				Edge e = new Edge(v, w, weight);
				addEdge(e);
			}
		}

		/**
		 * Returns the number of vertices in the edge-weighted graph.
		 * 
		 * @return the number of vertices in the edge-weighted graph
		 */
		public int V() {
			return V;
		}

		/**
		 * Returns the number of edges in the edge-weighted graph.
		 * 
		 * @return the number of edges in the edge-weighted graph
		 */
		public int E() {
			return E;
		}

		// throw an IndexOutOfBoundsException unless 0 <= v < V
		private void validateVertex(int v) {
			if (v < 0 || v >= V)
				throw new IndexOutOfBoundsException("vertex " + v
						+ " is not between 0 and " + (V - 1));
		}

		/**
		 * Adds the undirected edge <tt>e</tt> to the edge-weighted graph.
		 * 
		 * @param e
		 *            the edge
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless both endpoints are between 0 and V-1
		 */
		public void addEdge(Edge e) {
			int v = e.either();
			int w = e.other(v);
			validateVertex(v);
			validateVertex(w);
			adj[v].add(e);
			adj[w].add(e);
			E++;
		}

		/**
		 * Returns the edges incident on vertex <tt>v</tt>.
		 * 
		 * @return the edges incident on vertex <tt>v</tt> as an Iterable
		 * @param v
		 *            the vertex
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless 0 <= v < V
		 */
		public Iterable<Edge> adj(int v) {
			validateVertex(v);
			return adj[v];
		}

		/**
		 * Returns the degree of vertex <tt>v</tt>.
		 * 
		 * @return the degree of vertex <tt>v</tt>
		 * @param v
		 *            the vertex
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless 0 <= v < V
		 */
		public int degree(int v) {
			validateVertex(v);
			return adj[v].size();
		}

		/**
		 * Returns all edges in the edge-weighted graph. To iterate over the
		 * edges in the edge-weighted graph, use foreach notation:
		 * <tt>for (Edge e : G.edges())</tt>.
		 * 
		 * @return all edges in the edge-weighted graph as an Iterable.
		 */
		public Iterable<Edge> edges() {
			Bag<Edge> list = new Bag<Edge>();
			for (int v = 0; v < V; v++) {
				int selfLoops = 0;
				for (Edge e : adj(v)) {
					if (e.other(v) > v) {
						list.add(e);
					}
					// only add one copy of each self loop (self loops will be
					// consecutive)
					else if (e.other(v) == v) {
						if (selfLoops % 2 == 0)
							list.add(e);
						selfLoops++;
					}
				}
			}
			return list;
		}

		/**
		 * Returns a string representation of the edge-weighted graph. This
		 * method takes time proportional to <em>E</em> + <em>V</em>.
		 * 
		 * @return the number of vertices <em>V</em>, followed by the number of
		 *         edges <em>E</em>, followed by the <em>V</em> adjacency lists
		 *         of edges
		 */
		public String toString() {
			String NEWLINE = System.getProperty("line.separator");
			StringBuilder s = new StringBuilder();
			s.append(V + " " + E + NEWLINE);
			for (int v = 0; v < V; v++) {
				s.append(v + ": ");
				for (Edge e : adj[v]) {
					s.append(e + "  ");
				}
				s.append(NEWLINE);
			}
			return s.toString();
		}

	}

	class Bag<Item> implements Iterable<Item> {
		private int N; // number of elements in bag
		private Node<Item> first; // beginning of bag

		// helper linked list class
		private class Node<Item> {
			private Item item;
			private Node<Item> next;
		}

		/**
		 * Initializes an empty bag.
		 */
		public Bag() {
			first = null;
			N = 0;
		}

		/**
		 * Is this bag empty?
		 * 
		 * @return true if this bag is empty; false otherwise
		 */
		public boolean isEmpty() {
			return first == null;
		}

		/**
		 * Returns the number of items in this bag.
		 * 
		 * @return the number of items in this bag
		 */
		public int size() {
			return N;
		}

		/**
		 * Adds the item to this bag.
		 * 
		 * @param item
		 *            the item to add to this bag
		 */
		public void add(Item item) {
			Node<Item> oldfirst = first;
			first = new Node<Item>();
			first.item = item;
			first.next = oldfirst;
			N++;
		}

		/**
		 * Returns an iterator that iterates over the items in the bag in
		 * arbitrary order.
		 * 
		 * @return an iterator that iterates over the items in the bag in
		 *         arbitrary order
		 */
		public Iterator<Item> iterator() {
			return new ListIterator<Item>(first);
		}

		// an iterator, doesn't implement remove() since it's optional
		private class ListIterator<Item> implements Iterator<Item> {
			private Node<Item> current;

			public ListIterator(Node<Item> first) {
				current = first;
			}

			public boolean hasNext() {
				return current != null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public Item next() {
				if (!hasNext())
					throw new NoSuchElementException();
				Item item = current.item;
				current = current.next;
				return item;
			}
		}

	}

	class Edge implements Comparable<Edge> {

		private final int v;
		private final int w;
		private final double weight;

		/**
		 * Initializes an edge between vertices <tt>v/tt> and <tt>w</tt> of the
		 * given <tt>weight</tt>. param v one vertex param w the other vertex
		 * param weight the weight of the edge
		 * 
		 * @throws IndexOutOfBoundsException
		 *             if either <tt>v</tt> or <tt>w</tt> is a negative integer
		 * @throws IllegalArgumentException
		 *             if <tt>weight</tt> is <tt>NaN</tt>
		 */
		public Edge(int v, int w, double weight) {
			if (v < 0)
				throw new IndexOutOfBoundsException(
						"Vertex name must be a nonnegative integer");
			if (w < 0)
				throw new IndexOutOfBoundsException(
						"Vertex name must be a nonnegative integer");
			if (Double.isNaN(weight))
				throw new IllegalArgumentException("Weight is NaN");
			this.v = v;
			this.w = w;
			this.weight = weight;
		}

		/**
		 * Returns the weight of the edge.
		 * 
		 * @return the weight of the edge
		 */
		public double weight() {
			return weight;
		}

		/**
		 * Returns either endpoint of the edge.
		 * 
		 * @return either endpoint of the edge
		 */
		public int either() {
			return v;
		}

		/**
		 * Returns the endpoint of the edge that is different from the given
		 * vertex (unless the edge represents a self-loop in which case it
		 * returns the same vertex).
		 * 
		 * @param vertex
		 *            one endpoint of the edge
		 * @return the endpoint of the edge that is different from the given
		 *         vertex (unless the edge represents a self-loop in which case
		 *         it returns the same vertex)
		 * @throws java.lang.IllegalArgumentException
		 *             if the vertex is not one of the endpoints of the edge
		 */
		public int other(int vertex) {
			if (vertex == v)
				return w;
			else if (vertex == w)
				return v;
			else
				throw new IllegalArgumentException("Illegal endpoint");
		}

		/**
		 * Compares two edges by weight.
		 * 
		 * @param that
		 *            the other edge
		 * @return a negative integer, zero, or positive integer depending on
		 *         whether this edge is less than, equal to, or greater than
		 *         that edge
		 */
		public int compareTo(Edge that) {
			if (this.weight() < that.weight())
				return -1;
			else if (this.weight() > that.weight())
				return +1;
			else
				return 0;
		}

		/**
		 * Returns a string representation of the edge.
		 * 
		 * @return a string representation of the edge
		 */
		public String toString() {
			return String.format("%d %d %.5f", v, w, weight);
		}

	}

	public class Queue<Item> implements Iterable<Item> {
		private int N; // number of elements on queue
		private Node<Item> first; // beginning of queue
		private Node<Item> last; // end of queue

		// helper linked list class
		private class Node<Item> {
			private Item item;
			private Node<Item> next;
		}

		/**
		 * Initializes an empty queue.
		 */
		public Queue() {
			first = null;
			last = null;
			N = 0;
		}

		/**
		 * Is this queue empty?
		 * 
		 * @return true if this queue is empty; false otherwise
		 */
		public boolean isEmpty() {
			return first == null;
		}

		/**
		 * Returns the number of items in this queue.
		 * 
		 * @return the number of items in this queue
		 */
		public int size() {
			return N;
		}

		/**
		 * Returns the item least recently added to this queue.
		 * 
		 * @return the item least recently added to this queue
		 * @throws java.util.NoSuchElementException
		 *             if this queue is empty
		 */
		public Item peek() {
			if (isEmpty())
				throw new NoSuchElementException("Queue underflow");
			return first.item;
		}

		/**
		 * Adds the item to this queue.
		 * 
		 * @param item
		 *            the item to add
		 */
		public void enqueue(Item item) {
			Node<Item> oldlast = last;
			last = new Node<Item>();
			last.item = item;
			last.next = null;
			if (isEmpty())
				first = last;
			else
				oldlast.next = last;
			N++;
		}

		/**
		 * Removes and returns the item on this queue that was least recently
		 * added.
		 * 
		 * @return the item on this queue that was least recently added
		 * @throws java.util.NoSuchElementException
		 *             if this queue is empty
		 */
		public Item dequeue() {
			if (isEmpty())
				throw new NoSuchElementException("Queue underflow");
			Item item = first.item;
			first = first.next;
			N--;
			if (isEmpty())
				last = null; // to avoid loitering
			return item;
		}

		/**
		 * Returns a string representation of this queue.
		 * 
		 * @return the sequence of items in FIFO order, separated by spaces
		 */
		public String toString() {
			StringBuilder s = new StringBuilder();
			for (Item item : this)
				s.append(item + " ");
			return s.toString();
		}

		/**
		 * Returns an iterator that iterates over the items in this queue in
		 * FIFO order.
		 * 
		 * @return an iterator that iterates over the items in this queue in
		 *         FIFO order
		 */
		public Iterator<Item> iterator() {
			return new ListIterator<Item>(first);
		}

		// an iterator, doesn't implement remove() since it's optional
		private class ListIterator<Item> implements Iterator<Item> {
			private Node<Item> current;

			public ListIterator(Node<Item> first) {
				current = first;
			}

			public boolean hasNext() {
				return current != null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public Item next() {
				if (!hasNext())
					throw new NoSuchElementException();
				Item item = current.item;
				current = current.next;
				return item;
			}
		}

	}

	public class UF {
		private int[] id; // id[i] = parent of i
		private byte[] rank; // rank[i] = rank of subtree rooted at i (cannot be
								// more than 31)
		private int count; // number of components

		/**
		 * Initializes an empty union-find data structure with <tt>N</tt>
		 * isolated components <tt>0</tt> through <tt>N-1</tt>
		 * 
		 * @throws java.lang.IllegalArgumentException
		 *             if <tt>N &lt; 0</tt>
		 * @param N
		 *            the number of sites
		 */
		public UF(int N) {
			if (N < 0)
				throw new IllegalArgumentException();
			count = N;
			id = new int[N];
			rank = new byte[N];
			for (int i = 0; i < N; i++) {
				id[i] = i;
				rank[i] = 0;
			}
		}

		/**
		 * Returns the component identifier for the component containing site
		 * <tt>p</tt>.
		 * 
		 * @param p
		 *            the integer representing one object
		 * @return the component identifier for the component containing site
		 *         <tt>p</tt>
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless <tt>0 &le; p &lt; N</tt>
		 */
		public int find(int p) {
			if (p < 0 || p >= id.length)
				throw new IndexOutOfBoundsException();
			while (p != id[p]) {
				id[p] = id[id[p]]; // path compression by halving
				p = id[p];
			}
			return p;
		}

		/**
		 * Returns the number of components.
		 * 
		 * @return the number of components (between <tt>1</tt> and <tt>N</tt>)
		 */
		public int count() {
			return count;
		}

		/**
		 * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
		 * 
		 * @param p
		 *            the integer representing one site
		 * @param q
		 *            the integer representing the other site
		 * @return true if the two sites <tt>p</tt> and <tt>q</tt> are in the
		 *         same component; false otherwise
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless both <tt>0 &le; p &lt; N</tt> and
		 *             <tt>0 &le; q &lt; N</tt>
		 */
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		/**
		 * Merges the component containing site <tt>p</tt> with the the
		 * component containing site <tt>q</tt>.
		 * 
		 * @param p
		 *            the integer representing one site
		 * @param q
		 *            the integer representing the other site
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless both <tt>0 &le; p &lt; N</tt> and
		 *             <tt>0 &le; q &lt; N</tt>
		 */
		public void union(int p, int q) {
			int i = find(p);
			int j = find(q);
			if (i == j)
				return;

			// make root of smaller rank point to root of larger rank
			if (rank[i] < rank[j])
				id[i] = j;
			else if (rank[i] > rank[j])
				id[j] = i;
			else {
				id[j] = i;
				rank[i]++;
			}
			count--;
		}

	}

	public class MinPQ<Key> implements Iterable<Key> {
		private Key[] pq; // store items at indices 1 to N
		private int N; // number of items on priority queue
		private Comparator<Key> comparator; // optional comparator

		/**
		 * Initializes an empty priority queue with the given initial capacity.
		 * 
		 * @param initCapacity
		 *            the initial capacity of the priority queue
		 */
		public MinPQ(int initCapacity) {
			pq = (Key[]) new Object[initCapacity + 1];
			N = 0;
		}

		/**
		 * Initializes an empty priority queue.
		 */
		public MinPQ() {
			this(1);
		}

		/**
		 * Initializes an empty priority queue with the given initial capacity,
		 * using the given comparator.
		 * 
		 * @param initCapacity
		 *            the initial capacity of the priority queue
		 * @param comparator
		 *            the order to use when comparing keys
		 */
		public MinPQ(int initCapacity, Comparator<Key> comparator) {
			this.comparator = comparator;
			pq = (Key[]) new Object[initCapacity + 1];
			N = 0;
		}

		/**
		 * Initializes an empty priority queue using the given comparator.
		 * 
		 * @param comparator
		 *            the order to use when comparing keys
		 */
		public MinPQ(Comparator<Key> comparator) {
			this(1, comparator);
		}

		/**
		 * Initializes a priority queue from the array of keys. Takes time
		 * proportional to the number of keys, using sink-based heap
		 * construction.
		 * 
		 * @param keys
		 *            the array of keys
		 */
		public MinPQ(Key[] keys) {
			N = keys.length;
			pq = (Key[]) new Object[keys.length + 1];
			for (int i = 0; i < N; i++)
				pq[i + 1] = keys[i];
			for (int k = N / 2; k >= 1; k--)
				sink(k);
			assert isMinHeap();
		}

		/**
		 * Is the priority queue empty?
		 * 
		 * @return true if the priority queue is empty; false otherwise
		 */
		public boolean isEmpty() {
			return N == 0;
		}

		/**
		 * Returns the number of keys on the priority queue.
		 * 
		 * @return the number of keys on the priority queue
		 */
		public int size() {
			return N;
		}

		/**
		 * Returns a smallest key on the priority queue.
		 * 
		 * @return a smallest key on the priority queue
		 * @throws java.util.NoSuchElementException
		 *             if priority queue is empty
		 */
		public Key min() {
			if (isEmpty())
				throw new NoSuchElementException("Priority queue underflow");
			return pq[1];
		}

		// helper function to double the size of the heap array
		private void resize(int capacity) {
			assert capacity > N;
			Key[] temp = (Key[]) new Object[capacity];
			for (int i = 1; i <= N; i++)
				temp[i] = pq[i];
			pq = temp;
		}

		/**
		 * Adds a new key to the priority queue.
		 * 
		 * @param x
		 *            the key to add to the priority queue
		 */
		public void insert(Key x) {
			// double size of array if necessary
			if (N == pq.length - 1)
				resize(2 * pq.length);

			// add x, and percolate it up to maintain heap invariant
			pq[++N] = x;
			swim(N);
			assert isMinHeap();
		}

		/**
		 * Removes and returns a smallest key on the priority queue.
		 * 
		 * @return a smallest key on the priority queue
		 * @throws java.util.NoSuchElementException
		 *             if the priority queue is empty
		 */
		public Key delMin() {
			if (isEmpty())
				throw new NoSuchElementException("Priority queue underflow");
			exch(1, N);
			Key min = pq[N--];
			sink(1);
			pq[N + 1] = null; // avoid loitering and help with garbage
								// collection
			if ((N > 0) && (N == (pq.length - 1) / 4))
				resize(pq.length / 2);
			assert isMinHeap();
			return min;
		}

		/***********************************************************************
		 * Helper functions to restore the heap invariant.
		 **********************************************************************/

		private void swim(int k) {
			while (k > 1 && greater(k / 2, k)) {
				exch(k, k / 2);
				k = k / 2;
			}
		}

		private void sink(int k) {
			while (2 * k <= N) {
				int j = 2 * k;
				if (j < N && greater(j, j + 1))
					j++;
				if (!greater(k, j))
					break;
				exch(k, j);
				k = j;
			}
		}

		/***********************************************************************
		 * Helper functions for compares and swaps.
		 **********************************************************************/
		private boolean greater(int i, int j) {
			if (comparator == null) {
				return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
			} else {
				return comparator.compare(pq[i], pq[j]) > 0;
			}
		}

		private void exch(int i, int j) {
			Key swap = pq[i];
			pq[i] = pq[j];
			pq[j] = swap;
		}

		// is pq[1..N] a min heap?
		private boolean isMinHeap() {
			return isMinHeap(1);
		}

		// is subtree of pq[1..N] rooted at k a min heap?
		private boolean isMinHeap(int k) {
			if (k > N)
				return true;
			int left = 2 * k, right = 2 * k + 1;
			if (left <= N && greater(k, left))
				return false;
			if (right <= N && greater(k, right))
				return false;
			return isMinHeap(left) && isMinHeap(right);
		}

		/***********************************************************************
		 * Iterators
		 **********************************************************************/

		/**
		 * Returns an iterator that iterates over the keys on the priority queue
		 * in ascending order. The iterator doesn't implement <tt>remove()</tt>
		 * since it's optional.
		 * 
		 * @return an iterator that iterates over the keys in ascending order
		 */
		public Iterator<Key> iterator() {
			return new HeapIterator();
		}

		private class HeapIterator implements Iterator<Key> {
			// create a new pq
			private MinPQ<Key> copy;

			// add all items to copy of heap
			// takes linear time since already in heap order so no keys move
			public HeapIterator() {
				if (comparator == null)
					copy = new MinPQ<Key>(size());
				else
					copy = new MinPQ<Key>(size(), comparator);
				for (int i = 1; i <= N; i++)
					copy.insert(pq[i]);
			}

			public boolean hasNext() {
				return !copy.isEmpty();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public Key next() {
				if (!hasNext())
					throw new NoSuchElementException();
				return copy.delMin();
			}
		}

	}

}
