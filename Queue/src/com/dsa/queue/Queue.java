package com.dsa.queue;

public class Queue<T> {

	private Node<T> first;
	private Node<T> last;
	private int length = 0;

	public Queue(T value) {
		Node<T> newNode = new Node<T>(value);
		first = newNode;
		last = newNode;
		length = 1;
	}

	@SuppressWarnings("hiding")
	class Node<T> {
		T value;
		Node<T> next;

		Node(T value) {
			this.value = value;
		}
	}

	public void getFirst() {
		System.out.println("first : " + first.value);
	}

	public void getLast() {
		System.out.println("last : " + last.value);
	}

	public void getLength() {
		System.out.println("length : " + length);
	}

	public boolean isEmpty() {
		return (first == null && length == 0) ? true : false;
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		Node<T> temp = first;
		while (temp != null) {
			System.out.print(temp.value + " --> ");
			temp = temp.next;
		}
	}

	public void enqueue(T value) {
		Node<T> newNode = new Node<T>(value);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		length++;
	}

	public Node<T> dequeue() {
		if (isEmpty())
			return null;

		Node<T> temp = first;
		if (length == 1) {
			first = null;
			last = null;
		} else {
			first = first.next;
			temp.next = null;
		}
		length--;
		return temp;
	}

}
