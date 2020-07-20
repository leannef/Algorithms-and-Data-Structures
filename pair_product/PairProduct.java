/* PairProduct.java
   CSC 225 - Fall 2015
   Programming Assignment 1 - Template for PairProduct
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java PairProduct
	
   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java PairProduct file.txt
   where file.txt is replaced by the name of the text file.

   B. Bird - 05/01/2014
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the PairUp class
public class PairProduct{
	/* PairProduct225()
		The input array A will contain non-negative integers. The function
		will search the array A for a pair of elements which sum to 225.
		If such a pair is found, return true. Otherwise, return false.
		The function may modify the array A.
		Do not change the function signature (name/parameters).
	*/
	public static boolean PairProduct225(int[] A){
		
		int n = A.length;
		/* Your code here */
		
		int[] C = new int[226];	
		
		for (int i = 0; i<n ; i++){
			if (A[i] >=0 && A[i] <=225) {
				int x = A[i];
				C[x]++;
			}
		}

		for (int j=1; j<C.length; j++){
			if ( C[j] >0 && (225 % j== 0) && C[225/j] >0) {
		
				return true;	
			}
		
		}
				return false;
	}

	/* main()
	   Contains code to test the PairProduct225 function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the PairProduct225() function above 
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();
		
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);
		
		int[] array = new int[inputVector.size()];
		
		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);
		
		
		long startTime = System.currentTimeMillis();
		
		boolean pairExists = PairProduct225(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a pair of values which multiply to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
