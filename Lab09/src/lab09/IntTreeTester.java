package lab09;

public class IntTreeTester {
	public static void main(String[] args){


		// Example trees
		// Use PrintSideways to get a sense of the tree structures (and consult the instruction)
		IntTree empty_tree = new IntTree(0);
		IntTree tree1 = new IntTree(1);
		IntTree tree2 = new IntTree(2);
		IntTree tree3 = new IntTree(3);
		IntTree tree4 = new IntTree(4);
		IntTree tree6 = new IntTree(6);

		int[] arr1 = {3, 5, 2, 1, -1, 4, 6};
		IntTree tree_ref1 = new IntTree(arr1);

		int[] arr2 = {2, 8, 1, 0, -1, 7, 6, -1, -1, -1, -1, 4, -1, -1, 9};
		IntTree tree_ref2 = new IntTree(arr2);

		int[] arr3 = {2, 7, 1, 0, -1, 7, 6, -1, -1, -1, -1, 4, -1, -1, 7};
		IntTree tree_ref3 = new IntTree(arr3);

		int[] arr4 = {4, 4, 4, 4};
		IntTree tree_ref4 = new IntTree(arr4);

		// ********************* TESTS FOR LAB ****************************//

		// *** numEmpty() tests
		int n0 = empty_tree.numEmpty();
		if (n0 != 1)
			System.err.println("TEST FAILED: numEmpty() with empty tree");

		int n1 = tree1.numEmpty();
		if (n1 != 2)
			System.err.println("TEST FAILED: numEmpty() with tree1");

		int n2 = tree2.numEmpty();
		if (n2 != 3)
			System.err.println("TEST FAILED: numEmpty() with tree2");

		int n3 = tree3.numEmpty();
		if (n3 != 4)
			System.err.println("TEST FAILED: numEmpty() with tree3");

		int n4 = tree4.numEmpty();
		if (n4 != 5)
			System.err.println("TEST FAILED: numEmpty() with tree4");

		int n6 = tree6.numEmpty();
		if (n6 != 7)
			System.err.println("TEST FAILED: numEmpty() with tree6");

		int n_ref1 = tree_ref1.numEmpty();
		if (n_ref1 != 7)
			System.err.println("TEST FAILED: numEmpty() with tree_ref1");

		int n_ref2 = tree_ref2.numEmpty();
		if (n_ref2 != 9)
			System.err.println("TEST FAILED: numEmpty() with tree_ref2");

		// *** printLevel tests
		if (!empty_tree.printLevel(1).equals(""))
			System.err.println("TEST FAILED: printLevel() with empty tree");

		if (!tree_ref2.printLevel(1).equals("2\n"))
			System.err.println("TEST FAILED: printLevel() with tree_ref2: Test 1");

		if (!tree_ref2.printLevel(2).equals("8\n1\n"))
			System.err.println("TEST FAILED: printLevel() with tree_ref2: Test 2");
			
		if (!tree_ref2.printLevel(3).equals("0\n7\n6\n"))
			System.err.println("TEST FAILED: printLevel() with tree_ref2: Test 3");

		if (!tree_ref2.printLevel(4).equals("4\n9\n"))
			System.err.println("TEST FAILED: printLevel() with tree_ref2: Test 4");

		if (!tree_ref2.printLevel(5).equals(""))
			System.err.println("TEST FAILED: printLevel() with tree_ref2: Test 5");

		// *** getDepth tests
		if (empty_tree.getDepth() != 0)
			System.err.println("TEST FAILED: getDepth() with empty tree");

		if (tree1.getDepth() != 1)
			System.err.println("TEST FAILED: getDepth() with tree1");

		if (tree_ref1.getDepth() != 3)
			System.err.println("TEST FAILED: getDepth() with tree_ref1");

		if (tree_ref2.getDepth() != 4)
			System.err.println("TEST FAILED: getDepth() with tree_ref2");

         System.out.println("Testing done!!!");



		// ********************* TESTS FOR ASSIGNMENT ****************************//

		// *** toString() tests
		if (!empty_tree.toString().equals(""))
			System.err.println("TEST FAILED: toString() with empty tree");

		if (!tree2.toString().equals("(1, 2, empty)"))
			System.err.println("TEST FAILED: toString() with tree2");

		if (!tree3.toString().equals("(1, 2, 3)"))
			System.err.println("TEST FAILED: toString() with tree3");

		if (!tree4.toString().equals("(1, (2, 4, empty), 3)"))
			System.err.println("TEST FAILED: toString() with tree4");

		if (!tree6.toString().equals("(1, (2, 4, 5), (3, 6, empty))"))
			System.err.println("TEST FAILED: toString() with tree6");

		if (!tree_ref2.toString().equals("(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))"))
			System.err.println("TEST FAILED: toString() with tree_ref2");

		// *** luckyTree() tests
		if (empty_tree.luckyTree(7))
			System.err.println("TEST FAILED: luckyTree() with empty tree");
		if (tree2.luckyTree(7))
			System.err.println("TEST FAILED: luckyTree() with tree2");
		if (tree_ref2.luckyTree(7))
			System.err.println("TEST FAILED: luckyTree() with tree_ref2");
		if (!tree_ref3.luckyTree(7))
			System.err.println("TEST FAILED: luckyTree() with tree_ref3");
		if (!tree_ref4.luckyTree(4))
			System.err.println("TEST FAILED: luckyTree() with tree_ref4");

		// *** perfectify() tests
		empty_tree.perfectify();
		if (!empty_tree.getInorder().equals(""))
			System.err.println("TEST FAILED: perfectify() with empty tree");

		tree1.perfectify();
		if (!tree1.getInorder().equals(" 1 "))
			System.err.println("TEST FAILED: perfectify() with tree1");

		tree2.perfectify();
		if (!tree2.getInorder().equals(" 2  1  -1 "))
			System.err.println("TEST FAILED: perfectify() with tree2");

		tree3.perfectify();
		if (!tree3.getInorder().equals(" 2  1  3 "))
			System.err.println("TEST FAILED: perfectify() with tree3");

		tree4.perfectify();
		if (!tree4.getInorder().equals(" 4  2  -1  1  -1  3  -1 "))
			System.err.println("TEST FAILED: perfectify() with tree4");

		tree6.perfectify();
		if (!tree6.getInorder().equals(" 4  2  5  1  6  3  -1 "))
			System.err.println("TEST FAILED: perfectify() with tree6");

		tree_ref1.perfectify();
		if (!tree_ref1.getInorder().equals(" 1  5  -1  3  4  2  6 "))
			System.err.println("TEST FAILED: perfectify() with tree_ref1");

		tree_ref2.perfectify();
		if (!tree_ref2.getInorder().equals(" -1  0  -1  8  -1  -1  -1  2  4  7  -1  1  -1  6  9 "))
			System.err.println("TEST FAILED: perfectify() with tree_ref2");

         System.out.println("Testing done!!!");



	}
}
