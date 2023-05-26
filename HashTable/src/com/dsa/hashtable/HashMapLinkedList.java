package com.dsa.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

/** Leet-code problem **/
class HashMapLinkedList {
	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.value = value;
			this.key = key;
		}
	}

	private ArrayList<LinkedList<Node>> list = new ArrayList<>();

	public HashMapLinkedList() {

	}

	public void put(int key, int value) {
		int index = hash(key);
		Node newNode = new Node(key, value);

		if (!list.isEmpty()) {
			LinkedList<Node> ll = list.get(index);
			for (Node node : ll) {
				if (node.key == key) {
					node.value = value;
					return;
				}
			}
			ll.add(newNode);
		} else {
			LinkedList<Node> ll = new LinkedList<>();
			ll.add(newNode);
			list.add(ll);
		}

	}

	public int get(int key) {
		int index = hash(key);

		if (!list.isEmpty()) {
			LinkedList<Node> nodes = list.get(index);

			for (Node node : nodes) {
				if (node.key == key) {
					return node.value;
				}
			}
		}
		return -1;
	}

	public void printHashTable() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : ");
			LinkedList<Node> nodes = list.get(i);
			for (Node node : nodes) {
				System.out.print("   { " + node.key + " = " + node.value + " }");
			}
		}
	}

	public void remove(int key) {
		if (!list.isEmpty()) {
			int index = hash(key);

			LinkedList<Node> nodes = list.get(index);

			for (Node node : nodes) {
				if (node.key == key) {
					nodes.remove(node);
					return;
				}
			}
		}
	}

	private int hash(int key) {
		if (list.isEmpty()) {
			return 0;
		}
		return Math.abs(key) % list.size();
	}
}
