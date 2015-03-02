import java.util.Scanner;

/**
 * LargestBlock is a class that is used to find the largest square sub matrix in
 * a square matrix if it exists.
 *
 * @author Hong Zhan Huang
 * @version 1.0
 */
class LargestBlock{

	/** The matrix to be used to find a sub matrix */
	private int [][] myMatrix;

	/** The size of the square matrix's dimension */
	private int size;

	/** 
	 * default constructor for the class that takes in user input to fill the 
	 * elements of the square matrix with the use of the Scanner class
	 * @see Scanner
	 */
	public LargestBlock(){

		System.out.println("Enter the number of rows in the square matrix: ");

		Scanner in = new Scanner(System.in);
		size = in.nextInt();

		myMatrix = new int[size][size];

		System.out.println("Enter the matrix row by row: ");
		String text = "";
		
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
					myMatrix[i][j] = in.nextInt();
					text += myMatrix[i][j];
				}
			text += '\n';
		}

		System.out.println("\nThis is the matrix: \n" + text);	
	}
	

	/**
	 * The method that actually attempts to find the largest square submatrix if it
	 * exists.
	 */
	public void largestSubMatrix(){

		int [][] tempMatrix = new int[size][size];
		int maxCount = 0;
		int count = 0;

		for (int i = size - 1; i > -1; i--){

			for (int j = size - 1; j > -1; j--){

				if (myMatrix[i][j] == 0){
					tempMatrix[i][j] = 0;
				}
				else{
					
					if (i == size - 1 || j == size - 1)
						tempMatrix[i][j] = 1;
					else{

						//Right
						count = tempMatrix[i][j+1];
						//Below
						count = count > tempMatrix[i+1][j] ? tempMatrix[i+1][j] : count;
						//Right and below
						count = count > tempMatrix[i+1][j+1] ? tempMatrix[i+1][j+1] : count;

						tempMatrix[i][j] = count + 1;
						maxCount = tempMatrix[i][j] > maxCount ? tempMatrix[i][j] : maxCount;	
					}
				}
					
			}
		}

		if (maxCount > 1)
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					if (tempMatrix[i][j] == maxCount)
						System.out.println("Output: The largest block is at (" + i + "," + j +
								") with " + maxCount + " rows.");

		/* Testing code to check the the tempMatrix was working correctly
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				System.out.print(tempMatrix[i][j]);
			}
			System.out.println("\n");
		}
		*/

	}

	/** Testing main */
	public static void main(String[] args){
	
		LargestBlock cheese = new LargestBlock();
		cheese.largestSubMatrix();
	}
}
