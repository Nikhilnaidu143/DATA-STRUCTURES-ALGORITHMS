package com.dsa;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int length = 0;

	public DoublyLinkedList(int value) {
		Node node = new Node(value);
		head = node;
		tail = node;
		length = 1;
	}

	class Node {
		int value;
		Node next;
		Node prev;

		Node(int value) {
			this.value = value;
		}
	}

	public void getLength() {
		System.out.println("length : " + length);
	}

	public void getHead() {
		System.out.println("head : " + head.value);
	}

	public void getTail() {
		System.out.println("tail : " + tail.value);
	}

	public void printList() {
		if (head == null && length < 1) {
			System.out.println("Doubly linked list is empty...!");
			return;
		}
		Node tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.value + " --> ");
			tempNode = tempNode.next;
		}
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null && length < 1) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		length++;
	}

	public Node removeLast() {
		if (head == null && length < 1)
			return null;

		Node tempNode = tail;
		if (length == 1) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
			tempNode.prev = null;
		}
		length--;
		return tempNode;
	}

	public void prepend(int value) {
		Node newNode = new Node(value);
		if (head == null && length < 1) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		length++;
	}

	public Node removeFirst() {
		Node tempNode = head;
		if (head == null && length < 1) {
			return tempNode;
		} else if (length == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			tempNode.next = null;
			head.prev = null;
		}
		length--;
		return tempNode;
	}

	public Node get(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index not allowed");
			return null;
		} else {
			Node tempNode = head;
			if (index < index / 2) {
				for (int i = 0; i < index; i++) {
					tempNode = tempNode.next;
				}
			} else {
				tempNode = tail;
				for (int i = length - 1; i > index; i--) {
					tempNode = tempNode.prev;
				}
			}
			return tempNode;
		}
	}

	public boolean set(int index, int value) {
		Node node = get(index);
		if (node != null) {
			node.value = value;
			return true;
		}
		return false;
	}

	public boolean insert(int index, int value) {
		if (index < 0 || index > length) {
			System.out.println("Index not allowed");
			return false;
		}
		if (index == 0) {
			prepend(value);
			return true;
		}
		if (index == length) {
			append(value);
			return true;
		}

		Node current = get(index);
		Node before = current.prev;
		Node newNode = new Node(value);
		newNode.prev = before;
		before.next = newNode;
		newNode.next = current;
		current.prev = newNode;
		length++;
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index not allowed");
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node current = get(index);
		current.next.prev = current.prev;
		current.prev.next = current.next;
		current.next = null;
		current.prev = null;
		length--;
		return current;
	}

	public void reverse() {
		if (head == null || length <= 1)
			return;

		Node current = head;
		Node temp = null;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		temp = head;
		head = tail;
		tail = temp;
	}

	public boolean isPalindrome() {
		if (head == null || length < 1) {
			return false;
		} else if (length == 1) {
			return true;
		}
		Node current = head;
		Node temp = tail;
		while (current != null) {
			if (current.value != temp.value) {
				return false;
			}
			temp = temp.prev;
			current = current.next;
		}
		return true;
	}
	
	public void swapPairs() {
		if(head == null || length <= 1) {
			return;
		}
		
		Node current = head;
		for(int i = 0; i < length; i+=2) {
			if(current == null || current.next == null) {
				break;
			}
			int temp = current.next.value;
			current.next.value = current.value;
			current.value = temp;
			current = current.next.next;
		}
	}
}
