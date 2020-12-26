package lab02;

//import lab02.Matrix;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		numRows = rowDim;
		numColumns = colDim;
		data = new int [rowDim][colDim];
	}
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
		numRows = d.length;
		if(numRows != 0 ) {
			numColumns = d[0].length;
		}
		else {
		numColumns = 0;
		}
		data = new int[numRows][numColumns];
		for(int i = 0; i < numRows; i++ ) {
			for(int j = 0; j < numColumns; j++) {
				data[i][j] = d[i][j];
			}
		}
	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String displayed_Matrix = "\n";
        for (int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColumns; j++) {
            		displayed_Matrix += data[i][j];
            		displayed_Matrix += " ";
            	}
            	displayed_Matrix += "\n";
            }
		return displayed_Matrix; // placeholder		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		// WILL THIS WORK????????????
		if (m.numColumns != numColumns || m.numRows != numRows) {
			return false;
		}
		for(int i = 0; i < numRows; i++ ) {
			for(int j = 0; j < numColumns; j++) {
				if(data[i][j] != m.data[i][j] ) {
					return false;
				}
			}
		}
		return true;
	}

	public Matrix mult(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		if (numColumns != m.numRows) {
			return null;
		}
		
		int mult[][] = new int [numRows][m.numColumns];
		for(int i = 0; i < numRows; i++ ) {
			for(int j = 0; j < m.numColumns; j++) {
                for (int k = 0; k <  m.numRows; k++) { 
                	mult[i][j] += (data[i][k] * m.data[k][j]);
                	
                } 
			}
		}
		Matrix multiplication = new Matrix(mult);
		return multiplication; // placeholder
	}
	
	public Matrix add(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		if (m.numColumns != numColumns && m.numRows != numRows) {
			return null;
		}
		int add[][] = new int [numRows][numColumns];
		for(int i = 0; i < numRows; i++ ) {
			for(int j = 0; j < numColumns; j++) {
				add[i][j] = data[i][j] + m.data[i][j];
			}
		}
		Matrix addition = new Matrix(add);
		return addition; // placeholder
	}
    
    public Matrix transpose()
    {
        /*
         * TODO: replace the below return statement with the correct code,
         */
    	int[][] transpose = new int [numColumns][numRows];
    	for(int i=0; i < numColumns; i++) {
    		for(int j=0; j < numRows; j++) {
    			transpose[i][j] = data[j][i];
    		}
    	}
    	Matrix t = new Matrix(transpose);
    	
        return t; // placeholder
    }
}