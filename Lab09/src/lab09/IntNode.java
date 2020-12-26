package lab09;


// Chapter 17.1 - page 1021
// Class for storing a single node of a binary tree of ints

public class IntNode {
	public int data;
	public IntNode left;
	public IntNode right;
	
	//constructs a leaf node with given data
	public IntNode(int data){
		this(data, null, null);
	}
	
	// constructs a branch node with given data, left subtree, right subtree
	public IntNode(int data, IntNode left, IntNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}