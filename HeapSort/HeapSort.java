/* HeapSort.java
   CSC 225 - Fall 2015
   Assignment 3 - Template for Heap Sort
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java HeapSort

   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java HeapSort file.txt
   where file.txt is replaced by the name of the text file.

   M. Simpson & B. Bird - 11/16/2015
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the HeapSort class
public class HeapSort{
	/* HeapSort(A)
		Sort the array A using heap sort.
		You may add additional functions (or classes) if needed, but the entire program must be
		contained in this file. 
		Do not change the function signature (name/parameters).
	*/

	private static int[] A;
	private static int n;
    private static int left;
    private static int right;
    private static int largest;
     	    
    public static void buildheap(int []A){
        n=A.length-1;	//heap size initialised
        for(int i=n/2;i>=0;i--){ //since n/2,n/2+1... are leaves we can start from n/2 step downwards
            maxheap(A,i);	//call maxheap on each root node starting from n/2
        }
    }
    
    //Function to swap largest element in heap
    public static void maxheap(int[] A, int i){ 
        left=2*i;
        right=2*i+1;
 		//check if left index lies within the heap.
        //if element at left index is greater than root(A[i]) element, max heap property is violated
        //copy the index of violated element in largest       
        if(left <= n && A[left] > A[i]){
            largest=left;
        }
        else{			//if max heap property is not violated copy the root's index in largest
            largest=i;
        }
        //check to see the right sub tree for max heap property violation     
        if(right <= n && A[right] > A[largest]){
            largest=right;
        }
        //if root doesn't has the largest index then swap the largest element with root element
        if(largest!=i){
            exchange(i,largest,A);
            maxheap(A, largest); //after swap, recursively call the maxheap on the largest index(root element)
        }
    }
    
    public static void exchange(int i, int j,int[]A){
        int t=A[i];
        A[i]=A[j];
        A[j]=t; 	//swap two values
    }
    	
    public static void HeapSort(int[] A){    	
  
        buildheap(A);
        
        for(int i=n;i>0;i--){   //starting from end loop through entire array
            exchange(0, i,A);
            n=n-1;
            maxheap(A, 0);
        }
    }
   



	/* main()
	   Contains code to test the HeapSort function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the HeapSort() function above 
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

		HeapSort(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		//Don't print out the values if there are more than 100 of them
		if (array.length <= 100){
			System.out.println("Sorted values:");
			for (int i = 0; i < array.length; i++)
				System.out.printf("%d ",array[i]);
			System.out.println();
		}

		//Check whether the sort was successful
		boolean isSorted = true;
		for (int i = 0; i < array.length-1; i++)
			if (array[i] > array[i+1])
				isSorted = false;

		System.out.printf("Array %s sorted.\n",isSorted? "is":"is not");
		System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
	}
}