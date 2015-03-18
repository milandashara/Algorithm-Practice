package coursera.week2;

/**
 * Maintain pointer to first node in a linked list; insert/remove from front
 * 
 * @author Milan
 *
 */
public class LinkedStackOfStrings {

	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}

	public static void main(String[] args) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		
			String s = "to be or not to - be - - that - - - is ";
			if (s.equals("-"))
				System.out.print(stack.pop());
			else
				stack.push(s);
		
	}
}
