package com.dsa;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList myDLL = new DoublyLinkedList(1);

		myDLL.append(2);
		myDLL.append(3);
		myDLL.append(2);
		myDLL.append(1);
		
		System.out.println(myDLL.isPalindrome());
		
		
		myDLL.printList();
		System.out.println();
		myDLL.swapPairs();
		myDLL.printList();
		
		LinkedList<?> ll = new LinkedList<>();
		
	}
}
