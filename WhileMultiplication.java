//continuing the matrix multiplication task but redoing it in a while loop instead!
public class WhileMultiplication 
{
		//same example as last time 
	    Double[][] A = { { 4.00, 3.00 }, { 2.00, 3.00 } }; //matrix A (first)
	    Double[][] B = { { 2.00, 3.00 }, { 3.00, 3.00 } }; //matrix B (second)

	    public static Double[][] multiply(Double[][] A, Double[][] B) 
	    {
	        //getting sizes to check again if we can do multiplication is first columns match second rows
	        int firstRows = A.length;
	        int firstColumns = A[0].length;
	        int secondRows = B.length;
	        int secondColumns = B[0].length;

	        //check if multiplication is valid (columns of A == rows of B)
	        if (firstColumns != secondRows) 
	        {
	            throw new IllegalArgumentException("The A Rows are " + firstColumns + " which does not match B Columns: " + secondRows + ".");
	        }

	        Double[][] C = new Double[firstRows][secondColumns]; //result matrix initalizing

	        //initialize the result matrix with 0s until we no longer are out of the size for each row or column!
	        int i = 0;
	        while (i < firstRows) 
	        {
	        	//again for each column
	            int j = 0;
	            while (j < secondColumns) 
	            { 
	                C[i][j] = 0.00; //initalize to 0 so its 'empty' 
	                j++;
	            }
	            i++;
	        }

	        //perform the matrix multiplication same like last time! we just end at the end of the length technically of rows/column combination
	        i = 0; // initalize outside of loop 
	        while (i < firstRows)
	        { 
	            int j = 0;
	            while (j < secondColumns)
	            { 
	                int k = 0;
	                while (k < firstColumns) 
	                { 
	                    C[i][j] += A[i][k] * B[k][j]; //multiply and adds to get result in store in that position of matrix!
	                    k++;
	                }
	                j++;
	            }
	            i++;
	        }
	        //notice it is incrementing each time to move to the next iteration of loop
	        
	        return C;
	    }

	    
	    public static void main(String[] args) 
	    {
	        //creating matrix object
	        WhileMultiplication matrix = new WhileMultiplication();
	        //perform matrix multiplication
	        Double[][] resultMatrix = multiply(matrix.A, matrix.B);

	        //clarifying which to test out of curiousity to make sure both have same result
	        System.out.println("While loop result: ");
	        
	        //printing the result matrix
	        int i = 0;
	        while (i < 2) 
	        { //loop through rows of the result matrix - only to 2 bc its a 2 by 2 matrix 
	            System.out.print("[");
	            int j = 0;
	            while (j < 2) 
	            {
	                System.out.print(resultMatrix[i][j] + " ");
	                j++;
	            }
	            System.out.print("]");
	            System.out.println();
	            i++;
	        }
	        //finished! gets the same result as previous :)
	}

}
