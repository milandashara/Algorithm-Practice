import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ImmutableQueue<E> {

	int start;
	int end;
	List<E> queue;

	/**
	 * requires default constructor.
	 */
	public ImmutableQueue() {
		// modify this constructor if necessary, but do not remove default
		// constructor
		start = -1;
		end = -1;
		queue = new ArrayList<E>();
	}

	private ImmutableQueue(List<E> queue, int start, int end) {
		this.queue = queue;
		this.start = start;
		this.end = end;
	}

	// add other constructors if necessary
	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2, 1, 2, 2, 6, 4)
	 * and this object still represents the queue (2, 1, 2, 2, 6) .
	 * </pre>
	 * 
	 * If the element e is null, throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public ImmutableQueue<E> enqueue(E e) {
		if (start == -1) {
			start = 0;
			end = 0;
			queue.add(e);
			return new ImmutableQueue<E>(queue, start, end);
		} else {
			queue.add(e);
			return new ImmutableQueue<E>(queue, start, end + 1);
		}

	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
	 * this method returns a new queue (1, 3, 3, 5, 1)
	 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
	 * </pre>
	 * 
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public ImmutableQueue<E> dequeue() {
		if (start == -1 || end == -1 || start > end) {
			throw new NoSuchElementException();

		} else
			return new ImmutableQueue<E>(queue, start + 1, end);

	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1),
	 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
	 * </pre>
	 * 
	 * If the queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public E peek() {
		if (start == -1 || end == -1 || start > end) {
			throw new NoSuchElementException();
		} else
			return this.queue.get(start);
	}

	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return
	 */
	public int size() {
		if (start == -1 || end == -1)
			return 0;
		return end - start + 1;
	}

	public static void main(String[] args) {
		ImmutableQueue<String> q1 = new ImmutableQueue<String>();
		// System.out.println(q1.size());
		// System.out.println(q1.peek());
		ImmutableQueue<String> q2 = q1.enqueue("milan");
		System.out.println(q2.size());
		System.out.println(q2.peek());
		ImmutableQueue<String> q3 = q2.enqueue("ashara");
		System.out.println(q3.size());
		System.out.println(q3.peek());
		ImmutableQueue<String> q4 = q3.dequeue();
		System.out.println(q4.peek());
		q4 = q4.dequeue();

		System.out.println(q4.size());
		// System.out.println(q4.peek());

	}
}
