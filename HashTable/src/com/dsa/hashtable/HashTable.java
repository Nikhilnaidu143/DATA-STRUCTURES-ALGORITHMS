package com.dsa.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	private int size = 7;
	private Node[] dataMap;

	public HashTable() {
		dataMap = new Node[size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node[] getDataMap() {
		return dataMap;
	}

	public void setDataMap(Node[] dataMap) {
		this.dataMap = dataMap;
	}

	class Node {
		String key;
		int value;
		Node next;

		Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public void printHashTable() {
		for (int i = 0; i < dataMap.length; i++) {
			System.out.println(i + " : ");
			Node temp = dataMap[i];
			while (temp != null) {
				System.out.println("   { " + temp.key + " = " + temp.value + " }");
				temp = temp.next;
			}
		}
	}

	private int hash(String key) {
		int hashCode = Math.abs(key.hashCode());
		return hashCode % dataMap.length;
	}

	public void set(String key, int value) {
		int index = hash(key);

		Node newNode = new Node(key, value);

		if (dataMap[index] == null) {
			dataMap[index] = newNode;
		} else {
			Node temp = dataMap[index];
			while (temp != null) {
				if (temp.key == newNode.key) {
					temp.value += newNode.value;
					return;
				} else if (temp.next == null) {
					temp.next = newNode;
				} else {
					temp = temp.next;
				}
			}
		}
	}

	public Integer get(String key) {
		int index = hash(key);

		if (dataMap[index] != null) {
			Node temp = dataMap[index];
			while (temp != null) {
				if (temp.key == key) {
					return temp.value;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	public List<String> keys() {
		List<String> keys = new ArrayList<>();

		for (int i = 0; i < dataMap.length; i++) {
			Node temp = dataMap[i];
			while (temp != null) {
				keys.add(temp.key);
				temp = temp.next;
			}
		}
		return keys;
	}
}
