/* 
@ Summer Olmstead
Assignment 1 Survey Programming Languages
Matrix Multiplication 1.23.25

Task: To appreciate the value of counting loops (typically, for loop), write a program that implements matrix multiplication using counting loop constructs.
Then write the same program using only logical loops—for example, while loops.
*/

public class MatrixMultiplication // this one is for the for-loop method
{
	//rows by columns 2x2s - https://matrix.reshish.com/multiplication.php using this matrix calculator to check result lol 
	//declaring as a double for more versatility of operations
    Double[][] A = { { 4.00, 3.00 }, { 2.00, 3.00 } }; //lets just do this simple example matrix to test with 
    Double[][] B = { { 2.00, 3.00 }, { 3.00, 3.00 } };

    public static Double[][] multiply(Double[][] A, Double[][] B) 
    {
    	//creating method for multiplication and passing in two matrixes 
    	//must get the first matrix rows and col to test if it works same with second
        int firstRows = A.length;
        int firstColumns = A[0].length;
        int secondRows = B.length;
        int secondColumns = B[0].length;

        //must check if inner multiplication is same number aka 3x2 2x3 this would work - vs 3x3 and 4x3 wouldnt work as 3!=4
        if (firstColumns != secondRows) 
        {
            throw new IllegalArgumentException("The A Rows are " + firstColumns + " which does not match B Columns: " + secondRows + ".");
        }

        Double[][] C = new Double[firstRows][secondColumns]; //dimension of new matrix
        
        //initalizing open spaces in matrix
        for (int i = 0; i < firstRows; i++) 
        {
            for (int j = 0; j < secondColumns; j++) 
            {
                C[i][j] = 0.00;
            }
        }

        //doing calculations!
        for (int i = 0; i < firstRows; i++) //going through first row
        {
            for (int j = 0; j < secondColumns; j++) //multiplying to the second matrix's column 
            { 
                for (int k = 0; k < firstColumns; k++) // then to the first columns
                { 
                    C[i][j] += A[i][k] * B[k][j]; //saving formula to each spot/ position in matrix
                }
            }
        }

        return C; //returns matrix calculated!
    }

    
    public static void main(String[] args) 
    {
    	//creating matrix object
        MatrixMultiplication matrix = new MatrixMultiplication();
        //making a result matrix!
        Double[][] resultMatrix = multiply(matrix.A, matrix.B);

        //clarifying which to test out of curiousity to make sure both have same result
        System.out.println("For loop result: ");
        
        //printing out result matrix
        for (int i = 0; i < 2; i++) 
        {
        	System.out.print("[");
            for (int j = 0; j < 2; j++)
            {         	
            	System.out.print(resultMatrix[i][j] + " ");
            }	
            System.out.print("]");
            System.out.println(); //putting it into format for each row to restart
            
        }
    }
    
    //finished! :)
    
}
