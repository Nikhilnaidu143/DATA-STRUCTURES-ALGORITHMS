package com.dsa.bst;

public class Main {

	public static void main(String[] args) {
		//implemented binary search tree using java Generics.
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		/**
		 *                47
		 *          21         76
		 *      18     27  52      82
		 *      
		 * **/
		
		bst.insertRecursive(47);                   
		bst.insertRecursive(21);				
		bst.insertRecursive(76);
		bst.insertRecursive(18);
		bst.insertRecursive(27);
		bst.insertRecursive(52);
		bst.insertRecursive(82);
		
		
//		System.out.println(bst.conatinsRecursive(17));

		System.out.println("BFS: " + bst.breadthFirstSearch());
		System.out.println("DFS Pre-order: " + bst.deapthFirstSearchPreOrder());  //root - left - right
		System.out.println("DFS Post-order: " + bst.deapthFirstSearchPostOrder());//left - right - root
		System.out.println("DFS In-order: " + bst.depthFirstSearchInOrder());     //left - root - right
		
		System.out.println("size : " + bst.size());
	}
}
