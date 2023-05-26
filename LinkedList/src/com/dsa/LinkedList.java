package com.dsa;

public class LinkedList {
	private Node head;
	private Node tail;
	private int length = 0;

	class Node {
		public int value;
		public Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0 && head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	public void prepend(int value) {
		Node newNode = new Node(value);
		if (length == 0 && head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;

	}

	public Node removeLast() {
		if (length == 0 && head == null)
			return null;
		Node tempNode = head;
		Node prevNode = head;

		while (tempNode.next != null) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		if (tempNode.next == null) {
			tail = prevNode;
			tail.next = null;
		}
		if (length == 1) {
			head = null;
			tail = null;
		}
		length--;
		return tempNode;
	}

	public Node removeFirst() {
		if (length == 0 && head == null)
			return null;
		Node tempNode = head;

		head = head.next;
		tempNode.next = null;
		length--;
		return tempNode;
	}

	public Node get(int index) {
		if ((length == 0 && head == null) || index < 0)
			return null;

		Node tempNode = head;
		int i = 0;

		while (tempNode.next != null) {
			if (i == index) {
				return tempNode;
			}
			tempNode = tempNode.next;
			i++;
		}
		if (i == index) {
			return tempNode;
		} else {
			return null;
		}
	}

	public boolean set(int index, int value) {
		Node node = get(index);
		if (node != null) {
			node.value = value;
		} else {
			return false;
		}
		return true;
	}

	public boolean insert(int index, int value) {
		if (index < 0 || index > length)
			return false;
		Node newNode = new Node(value);

		if (length == 0 && head == null) {
			head = newNode;
			tail = newNode;
		} else if (length == 1 && index != 0) {
			head.next = newNode;
		} else if (index == 0 && length == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			Node tempNode = head;
			Node prevNode = head;
			int i = 0;
			while (tempNode.next != null) {
				if (index == 0 && i == 0) {
					newNode.next = head;
					tail = head;
					head = newNode;
					break;
				}
				if (i == index) {
					prevNode.next = newNode;
					newNode.next = tempNode;
					break;
				}
				prevNode = tempNode;
				tempNode = tempNode.next;
				i++;
			}
			if (i == index && index != 0) {
				prevNode.next = newNode;
				newNode.next = tempNode;
			}
			if (index == length) {
				tempNode.next = newNode;
				tail = newNode;
			}
		}
		length++;
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index >= length)
			return null;

		Node tempNode = get(index);
		if (tempNode != null) {
			Node prevNode = get(index - 1);
			if (length == 1) {
				head = null;
				tail = null;
			}
			if (tempNode == head) {
				head = tempNode.next;
			}
			if (prevNode != null) {
				prevNode.next = tempNode.next;
			}
			length--;
		}
		return tempNode;
	}

	public void reverse() {
		Node tempNode = head;
		head = tail;
		tail = tempNode;

		Node after = tempNode.next;
		Node before = null;

		for (int i = 0; i < length; i++) {
			after = tempNode.next;
			tempNode.next = before;
			before = tempNode;
			tempNode = after;
		}

	}

	public void printList() {
		if (length == 0 && head == null) {
			System.out.print("Linked List is empty");
		} else {
			Node tempNode = head;
			while (tempNode.next != null) {
				System.out.print(tempNode.value + " -> ");
				tempNode = tempNode.next;
			}
			System.out.print(tempNode.value + " -> ");
		}
	}

	/**
	 * 
	 * problem: Implement a method called findMiddleNode that returns the middle
	 * node of the linked list.
	 * 
	 * If the list has an even number of nodes, the method should return the second
	 * middle node.
	 * 
	 * In this problem, you should use the slow and fast pointer technique (also
	 * known as Floyd's Tortoise and Hare algorithm) to find the middle element of
	 * the linked list efficiently. DO NOT use the length attribute in your
	 * solution.
	 */
	public Node findMiddleNode() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;

	}

	/**
	 * 
	 * Implement a method called hasLoop that checks whether the list contains a
	 * loop or not.
	 * 
	 * If the list contains a loop, the method should return true; otherwise, it
	 * should return false.
	 * 
	 * Note:
	 * 
	 * In this problem, you should use the slow and fast pointer technique (also
	 * known as Floyd's Tortoise and Hare algorithm) to efficiently detect the
	 * presence of a loop in the linked list.
	 * 
	 * 
	 */
	public boolean hasLoop() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Implement a method called findKthFromEnd that returns the k-th node from the
	 * end of the list.
	 * 
	 * If the list has fewer than k nodes, the method should return null.
	 * 
	 * Note:
	 * 
	 * In this problem, you should use the two-pointer technique to efficiently find
	 * the k-th node from the end of the linked list.
	 * 
	 * @param k
	 * @return
	 */
	public Node findKthFromEnd(int k) {
		Node slow = head;
		Node fast = head;

		for (int i = 0; i < k; i++) {
			if (fast == null) {
				return null;
			} else {
				fast = fast.next;
			}
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	/**
	 * 
	 * In the LinkedList class, implement a method called reverseBetween that
	 * reverses the nodes of the list between indexes m and n (inclusive).
	 * 
	 * Note: the Linked List does not have a tail which will make the implementation
	 * easier.
	 * 
	 * The method should not return any value, and it should modify the original
	 * linked list.
	 * 
	 * The positions m and n are 0-indexed.
	 * 
	 * Notes:
	 * 
	 * The method should not duplicate any of the existing nodes, only rearranging
	 * the existing nodes in the list.
	 * 
	 * However, the creation of a limited number of new nodes is allowed (e.g.,
	 * dummy nodes to facilitate the partitioning process).
	 * 
	 * The method should not use any extra data structures such as arrays or lists.
	 */
	public void reverseBetween(int m, int n) {
		if (head == null || m < 0 || n > length - 1)
			return;

		Node dummy = new Node(0);

		dummy.next = head;
		Node previous = dummy;

		for (int i = 0; i < m; i++) {
			previous = previous.next;
		}

		Node current = previous.next;

		for (int i = 0; i < n - m; i++) {
			Node after = current.next;
			current.next = after.next;
			after.next = previous.next;
			previous.next = after;
		}
		head = dummy.next;
	}

	/**
	 * Write insertionSort() method that sorts a singly linked list in ascending
	 * order using the Insertion Sort algorithm. The method should take no input
	 * arguments.
	 * 
	 * The insertionSort() method should sort the linked list in place by repeatedly
	 * inserting each unsorted node into its correct position in the sorted part of
	 * the list. If the length of the linked list is less than 2, the method should
	 * simply return because the list is already sorted. After the sort, the method
	 * should update the head and tail pointers of the linked list to point to the
	 * first and last nodes, respectively.
	 * 
	 * The implementation should start with a sortedListHead variable that initially
	 * points to the head of the list, and a unsortedListHead variable that
	 * initially points to the second node in the list (if it exists). The method
	 * should then iterate through the unsorted part of the list and insert each
	 * node into its correct position in the sorted part of the list.
	 * 
	 * If a node in the unsorted part of the list is less than the head of the
	 * sorted part of the list, it should become the new head of the sorted list.
	 * Otherwise, the method should iterate through the sorted part of the list
	 * using a searchPointer variable until it finds the correct position to insert
	 * the node. The node should then be inserted into the sorted list by updating
	 * the next reference of the previous node to point to the new node, and the
	 * next reference of the new node to point to the next node in the sorted part
	 * of the list.
	 * 
	 **/
	public void insertionSort() {
		if (length < 2)
			return;
		Node sortedListHead = head;
		Node unsortedListHead = head.next;

		sortedListHead.next = null;

		while (unsortedListHead != null) {
			Node currentNode = unsortedListHead;
			unsortedListHead = unsortedListHead.next;
			if (currentNode.value < sortedListHead.value) {
				currentNode.next = sortedListHead;
				sortedListHead = currentNode;
			} else {
				Node searchPointer = sortedListHead;
				while (searchPointer.next != null && currentNode.value >= searchPointer.next.value) {
					searchPointer = searchPointer.next;
				}
				currentNode.next = searchPointer.next;
				searchPointer.next = currentNode;
			}
		}
		head = sortedListHead;
		tail = sortedListHead;
		while (tail.next != null) {
			tail = tail.next;
		}
	}
}
