/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package lab02;

public class MatrixTester {
		public static void main(String[] args)
		{			
			Matrix M1 = new Matrix(new int[][]
			                                 {{1, 2, 3},
											  {4, 5, 6}});
			
			Matrix M2 = new Matrix(new int[][]
			                                 {{7, 8, 9},
											  {10, 11, 12}});
			
			Matrix M3 = new Matrix(new int[][] {{7, 8},
												{9, 10}, 
												{11, 12}});
			
			/* 
			 * Note that none of the tests below will be correct until you have implemented all methods.
			 * This is just one example of a test, you must write more tests and cover all cases.
			 */			
			System.out.println(M1);
			Matrix ComputedAddition = M1.add(M2);
			System.out.println(M1);
			System.out.println("Computed result for M1 + M2:\n" + ComputedAddition);
						
			// this is the known correct result of multiplying M1 by M2
			Matrix referenceMultiply = new Matrix(new int[][]
			                                                {{58, 64},
															 {139, 154}});			
			
			// get the matrix computed by your mult method
			Matrix computedMultiply = M1.mult(M3);
			
			// exercises your toString method
			System.out.println("Computed result for M1 * M3:\n" + computedMultiply); 
			
			// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
			if(!referenceMultiply.equals(computedMultiply)) 
				System.out.println("Your multiplication is wrong. Should be:\n" + referenceMultiply);
			
			//TODO: fill in more tests that fully exercise all of your methods
			Matrix TransposeM1 = M1.transpose();
			Matrix TransposeM2 = M2.transpose();
			Matrix TransposeM3 = M3.transpose();
			Matrix ComputedAddition1 = M1.add(M3);
			Matrix ComputedAddition2 = M2.add(M3);
		}		
}