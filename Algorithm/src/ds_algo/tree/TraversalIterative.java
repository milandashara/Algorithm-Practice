package ds_algo.tree;

import problems.mst.Stack;

public class TraversalIterative {

	static void inorder(Node root) {
		if (root == null) {
			return;
		}

		//keep the nodes in the path that are waiting to be visited
		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		//first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.key + " ");
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	public static void main(String args[]) {

        /* creating a binary tree and entering
         the nodes */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		inorder(tree.root);
	}
}
