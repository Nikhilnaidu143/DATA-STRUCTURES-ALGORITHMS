package com.dsa;

import com.dsa.LinkedList.Node;

public class Main {
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		
		linkedList.printList();
		
		System.out.println();
		
		Node n = linkedList.get(0);
		System.out.println(n!=null ? n.value : "Index not found");
		
		System.out.println();
		
		System.out.println(linkedList.insert(5, 200));
		linkedList.printList();

		System.out.println();
		
		linkedList.reverseBetween(1,4);
		linkedList.printList();
		
		System.out.println();
		linkedList.insertionSort();
		linkedList.printList();
	}
}
