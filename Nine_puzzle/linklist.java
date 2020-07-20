import java.util.*;

public class linklist{

	public static void main(String[] args){
		//Creating a LinkedList array, one LinkedList for each vertex.
		LinkedList[] vertex = new LinkedList[362880]; // The number of vertices in your graph should be 9! which is 362880
		for(int i=0;i<362880;i++)
		{
			vertex[i] = new LinkedList(); // initializing each linked list to avoid NullPointerException
		}
		
		//Just randomly adding some edges
		vertex[23].add(56); // edge (23, 56)
		vertex[23].add(5222); //edge (23, 5222)
		
		vertex[555].add(5896); //edge (555, 5896)
		vertex[5623].add(89652); //edge (5623,89652)
		
		
		//Just printing the linked lists
		for(int i=0;i<362880;i++){
			if(!vertex[i].isEmpty()){ 
				System.out.println(i + " --> " + vertex[i]);
			}
		}
	}
}