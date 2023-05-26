package com.dsa.queue;

public class Main {

	public static void main(String[] args) {
		// Implemented Queue using Linked List and Java Generics.
		Queue<String> queue = new Queue<String>("one");

		queue.printQueue();

		queue.enqueue("two");
		queue.enqueue("three");

		System.out.println();
		queue.printQueue();
		
	}

}
