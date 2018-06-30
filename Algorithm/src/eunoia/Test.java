package eunoia;/*
   1. Only write your code in the methods that have the comment 'write your code here' or in the section 'write optional helper methods here'
   2. Do not modify anything else
   3. If your code cannot compile or fails the test cases in 'main()', you will not receive a response from us
*/

import java.util.*;
import java.util.regex.*;

public class Test {
	public static void main(String... args) {

		/*
		   Consider the following tree:

		         1
		      /  |  \
		     2   4   6
		   / |  / \  |  \  
		  3  9 5  7  11 12
		      / \      / | \
		     13 16    14 23 17
		       / \
		      24 32


		  Assuming the numbers are the ids of each node, the tree can be written down as follows:

		  1(2,4,6) 2(3,9) 4(5,7) 6(11,12) 5(13,16) 12(14,23,17) 16(24,32)

		  In the example above, for the group 1(2,4,6), node 2, 4 and 6 are the child nodes of
		  node 1. Note that extra whitespaces should be accepted. Assume ids are positive integers only.
		*/

		Tree first = new Tree("1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )");

		assertTrue(first.getLevelOfNodeWithId(1) == 5);
		assertTrue(first.getLevelOfNodeWithId(4) == 4);
		assertTrue(first.getLevelOfNodeWithId(5) == 3);
		assertTrue(first.getLevelOfNodeWithId(12) == 3);
		assertTrue(first.getLevelOfNodeWithId(16) == 2);
		assertTrue(first.getLevelOfNodeWithId(23) == 2);
		assertTrue(first.getLevelOfNodeWithId(32) == 1);

		/*
		      2
		   / | | \ 
		  5  4 3  1
		  |     \
		  7      9
		 / \   /  \
		12 10 11  14
		    |
		    13
		   / | \
		 16  8  15
		*/

		Tree second = new Tree(" 2(5, 4, 3,1)  5(7)   3(9) 7(12, 10)   9(11, 14)  10(13) 13(16,8,15)");
		assertTrue(second.getLevelOfNodeWithId(2) == 6);
		assertTrue(second.getLevelOfNodeWithId(5) == 5);
		assertTrue(second.getLevelOfNodeWithId(3) == 5);
		assertTrue(second.getLevelOfNodeWithId(12) == 3);
		assertTrue(second.getLevelOfNodeWithId(11) == 3);
		assertTrue(second.getLevelOfNodeWithId(13) == 2);
		assertTrue(second.getLevelOfNodeWithId(8) == 1);
	}

	private static void assertTrue(boolean v) {
		if(!v) {
			Thread.dumpStack();
			System.exit(0);
		}
	}
}

class Tree {
	private Node root;

	// do not add new properties

	public Tree(String treeData) {
		// write your code here
		String parentChilds[] = treeData.split("\\)\\s+");

		for (int j=0;j<parentChilds.length;j++) {

			Pattern p = Pattern.compile("-?\\d+");
			Matcher m = p.matcher(parentChilds[j]);
			if (m.find()){

				int parentId=Integer.parseInt(m.group());

				//search node if it exist
				Node node = search(parentId,this.root);

				//root node
				if (node == null){
					this.root = new Node(parentId);
					node = this.root;
				}

				//add children
				while (m.find()){
					String id = m.group();
					node.appendChild(new Node(Integer.parseInt(id)));
				}
			}

		}

	}

	/**
	  * Finds a node with a given id and return it's level.
	  * The nodes at the bottom of the tree have a level of 1. 
	  *
	  * @param id The id of node
	  * @return The level of the the node of that id, or -1 if a node is not found 
	  */
	public int getLevelOfNodeWithId(int id) {

		//search node if it exist
		Node node = search(id,this.root);

		if (node == null){
			return -1;
		}

		int level = getLevel(root, node, 1);
		int height = getHeight(root);
		return height - level + 1;

	}


	// write optional helper methods here
	private Node search(int id, Node node){
		if(node != null){
			if(node.getId() == id){
				return node;
			} else {

				for (Node n:node.getChildren()){
					Node foundNode = search(id, n);
					if(foundNode != null) {
						return foundNode;
					}

				}

			}
		} else {
			return null;
		}

		return null;
	}

	private int getHeight(Node node)
	{

		if (node == null){
			return -1;
		}

		if (node.getChildren().size() == 0)
			return 1;
		else
		{
			/* compute the depth of each subtree */
			int maxDepth = Integer.MIN_VALUE;
			for (Node n:node.getChildren()){
				int depth = getHeight(n);
				if(depth > maxDepth){
					maxDepth = depth;

				}
			}

			return (maxDepth+1);

		}
	}

	private int getLevel(Node node, Node currentNode,int level)
	{

		if (node.getId() == currentNode.getId())
			return level;

		if (node.getChildren().size() == 0)
			return 0;

		int downlevel = 0;
		for (Node n:node.getChildren()){

			downlevel = getLevel(n, currentNode, level + 1);
			if (downlevel != 0)
				return downlevel;
		}

		return downlevel;
	}

}

class Node {
	private Node parent;
	private List<Node> children;
	private int id;

	public Node(int id) {
		this.id = id;
		this.children = new ArrayList<Node>();
	}

	public Node(int id, Node parent) {
		this(id);
		this.parent = parent;
	}

	public void appendChild(Node child) {
		children.add(child);
	}

	public int getId() {
		return id;
	}

	public List<Node> getChildren() {
		return Collections.unmodifiableList(children);
	}
}
