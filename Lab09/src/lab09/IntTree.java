package lab09;

// Chapter 17.2 - page 1035 (modified)
// Simple binary tree class that includes methods to construct a tree of ints, to print the data using an
// inorder traversal. The trees build have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the trees.
public class IntTree {
	private IntNode root;

	public IntTree(int[] arr){
		if (arr.length == 0)
			throw new IllegalArgumentException("empty array");
		root = builTreeArray(1, arr);
	}

	private IntNode builTreeArray(int n, int[] arr){
		if (n > arr.length){
			return null;
		}else{
			if (arr[n-1] != -1){
				return new IntNode(arr[n-1], builTreeArray(2*n, arr), builTreeArray(2*n+1, arr));
			}else{
				return null;
			}
		}
	}

	// pre: max >= 0 (throws IllegalArgumentException if not)
	// post: constructs a sequential tree with given number of nodes
	public IntTree(int max){
		if (max < 0){
			throw new IllegalArgumentException("max: " + max);
		}
		root = buildTree(1, max);
	}

	// post: returns a sequential tree with n as its root unless n is greater than max, in which case it
	// returns an empty tree
	private IntNode buildTree(int n, int max){
		if (n > max){
			return null;
		}else{
			return new IntNode(n, buildTree(2*n, max), buildTree(2*n+1, max));
		}
	}

	public String getInorder(){
		return getInorder(root);
	}

	private String getInorder(IntNode root){
		if (root != null){
			return (getInorder(root.left) + " " + root.data + " " + getInorder(root.right));
		}else{
			return "";
		}
	}

	// post: prints the tree contents using an inorder traversal
	public void printInorder(){
		System.out.print("inorder:");
		printInorder(root);
		System.out.println();
	}

	// post: prints in inorder the tree with given root
	private void printInorder(IntNode root){
		if (root != null){
			printInorder(root.left);
			System.out.print(" " + root.data);
			printInorder(root.right);
		}
	}


	// post: prints the tree contents, one per line, following an inorder traversal and using indentation to
	//indicate node depth; prints right to left so that it looks correct when the output is rotated.
	public void printSideways(){
		printSideways(root, 0);
	}

	// post: prints in reversed preorder the tree with given root, indenting each line to the given level
	private void printSideways(IntNode root, int level){
		if (root != null){
			printSideways(root.right, level+1);
			for (int i = 0; i < level; i++){
				System.out.print("       ");
			}
			System.out.println(root.data);
			printSideways(root.left, level+1);
		}
	}

	//==================================================

	// A binary tree is "lucky" if it contains at least 3 occurrences of some value. Write a method
	// called luckyTree that checks to see if the given value occurs at least three times. If the
	// tree is "lucky", return true; otherwise, return false.
	public boolean luckyTree(int value) {
		// *FILL IN
		if(luckyTree(root,value) >= 3) {
			return true;
		}
		return false;
	}
	private int luckyTree(IntNode root, int value) {
		if(root == null) {
			return 0;
		}
		else if(root.data == value) {
			return 1 + luckyTree(root.left,value) + luckyTree(root.right, value);
		}
		else {
			return luckyTree(root.left,value) + luckyTree(root.right, value);
		}
	}

	// Write a method called perfectify that adds nodes until the binary tree is a perfect tree. A perfect
	// binary tree is one where all leaves are at the same level. Another way of thinking of it is that you
	// are adding dummy nodes to the tree until every path from the root to a leaf is the same length. A
	// perfect tree's shape is triangular and every branch node has exactly two children, and all of the
	// leaves are at the same level. Each new node you add to the tree should store the value -1.
	public void perfectify(){
		// *FILL IN
		root = makePerfect(root, 1);
	}
	private IntNode makePerfect(IntNode root, int level) {
	    if (level <= height()) {
	        if (root == null) {
	            root = new IntNode(-1);
	        }
	        root.left = makePerfect(root.left, level + 1);
	        root.right = makePerfect(root.right, level + 1);
	    }
	    return root;
	}
	public int height() {
	    return height(root);
	}

	private int height(IntNode root) {
	    if (root == null) {
	        return 0;
	    } else {
	        return 1 + Math.max(height(root.left), height(root.right));
	    }
	}
	

	// This method returns the depth of the tree as an integer.
	// We will use the same convention as in printLevel where the top root is at depth 1,
	// its children are at depth 2, and so on.
	// If the tree is empty, the method should return 0.
	public int getDepth(){
		return getDepth(root);
	}
	private int getDepth(IntNode root){
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(getDepth(root.left),getDepth(root.right));
	}

	// Write a method called printLevel that accepts an integer parameter n and returns the values at level n
	// as a string, from left to right, one per line . We will use the convention that the overall root is at level 1, its
	// children are at level 2, and so on. If there are no values at the level, your method should return an
	// empty string. Your method should return an empty string if it is passed a value for a level that
	// is less than 1. See the instruction for example output.

	public String printLevel(int level){
		// *FILL IN
		if(printLevel(root, level) == "") {
			return printLevel(root, level);
		}
		return printLevel(root, level);
	}
	//printLevel recursive Method
	private String printLevel(IntNode root, int level)
	{
		if(level < 0)
			throw new IllegalArgumentException();
	
		if(root == null)
			return "";

		if(level == 1){
			return Integer.toString(root.data) + "\n";
		}
		else{
			return printLevel(root.left, level - 1) + printLevel(root.right, level - 1);
		}
	}

	// Write a method called numEmpty that returns the number of empty branches in a tree. An empty tree is
	// considered to have one empty branch (the tree itself). For nonempty trees, your methods should count the
	// total number of empty branches among the nodes of the tree. A leaf node has two empty branches, a node
	// with one nonempty child has one empty branch, and a node with two nonempty children has no empty branches.
	// See the instruction for example output.
	public int numEmpty(){
		// *FILL IN
		return numEmpty(root);
	}
	//numEmpty recursive Method
	private int numEmpty(IntNode root) {
	    if (root == null) {
	        return 1;
	    } 
	    else {
	        return numEmpty(root.left) + numEmpty(root.right);
	    }
	}

	// write a toString method for a binary tree of integers. The method should return "empty" for an empty tree.
	// For a leaf node, it should return the data in the node as a string. For a branch node, it should return a
	// parenthesized String that has three elements separately by commas: the data at the root, a string
	// representation of the left subtree, and then a string representation of the right subtree.
	// See the instruction for example output.
	public String toString(){
		// *FILL IN
		if(root == null) {
			return "";
		}
		return toString(root);
		
	}
	private String toString(IntNode root) {
	    if (root == null) {
	        return "empty";
	    } else if (root.left == null && root.right == null) {
	        return "" + root.data;
	    } else {
	        return "(" + root.data + ", " + toString(root.left) + ", " + toString(root.right) + ")";
	    }
	}
	

}
