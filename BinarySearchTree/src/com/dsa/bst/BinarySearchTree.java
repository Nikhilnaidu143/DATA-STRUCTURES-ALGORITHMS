package com.dsa.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node<T> root;

	public BinarySearchTree() {
	}

	@SuppressWarnings("hiding")
	class Node<T extends Comparable<T>> {
		T value;
		Node<T> left;
		Node<T> right;

		Node(T value) {
			this.value = value;
		}
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public boolean insert(T value) {
		Node<T> newNode = new Node<T>(value);

		if (root == null) {
			root = newNode;
			return true;
		}
		Node<T> temp = root;
		while (true) {
			if (temp.value.compareTo(newNode.value) == 0) {
				System.out.println("value is already present in BST.");
				return false;
			} else if (newNode.value.compareTo(temp.value) < 0) {
				if (temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			} else if (newNode.value.compareTo(temp.value) > 0) {
				if (temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}
	}

	public boolean contains(T value) {
		Node<T> temp = root;
		while (temp != null) {
			if (temp.value.compareTo(value) == 0) {
				return true;
			} else if (value.compareTo(temp.value) < 0) {
				temp = temp.left;
			} else if (value.compareTo(temp.value) > 0) {
				temp = temp.right;
			}
		}
		return false;
	}

	public boolean conatinsRecursive(T value) {
		return conatinsRecursive(root, value);
	}

	private boolean conatinsRecursive(Node<T> root, T value) {
		if (root == null) {
			return false;
		} else if (root.value.compareTo(value) == 0) {
			return true;
		} else if (root.value.compareTo(value) > 0) {
			return conatinsRecursive(root.left, value);
		} else if (root.value.compareTo(value) < 0) {
			return conatinsRecursive(root.right, value);
		}
		return false;
	}

	public void insertRecursive(T value) {
		if (root == null)
			root = new Node<T>(value);
		insertRecursive(root, value);
	}

	private Node<T> insertRecursive(Node<T> currentNode, T value) {
		if (currentNode == null)
			return new Node<T>(value);
		if (currentNode.value.compareTo(value) > 0) {
			currentNode.left = insertRecursive(currentNode.left, value);
		} else if (currentNode.value.compareTo(value) < 0) {
			currentNode.right = insertRecursive(currentNode.right, value);
		}
		return currentNode;
	}

	public void deleteNode(T value) {
		deleteNode(root, value);
	}

	private Node<T> deleteNode(Node<T> currentNode, T value) {
		if (currentNode == null) {
			return null;
		}
		if (currentNode.value.compareTo(value) > 0) {
			currentNode.left = deleteNode(currentNode.left, value);
		} else if (currentNode.value.compareTo(value) < 0) {
			currentNode.right = deleteNode(currentNode.right, value);
		} else {
			if (currentNode.left == null && currentNode.right == null) {
				return null;
			} else if (currentNode.left == null && currentNode.right != null) {
				currentNode = currentNode.right;
				return currentNode;
			} else if (currentNode.left != null && currentNode.right == null) {
				currentNode = currentNode.left;
				return currentNode;
			} else {
				T subtreeMin = minimumValue(currentNode.right);
				currentNode.value = subtreeMin;
				currentNode.right = deleteNode(currentNode.right, subtreeMin);
			}
		}
		return currentNode;
	}

	private T minimumValue(Node<T> currentNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.value;
	}

	public ArrayList<T> breadthFirstSearch() {
		Node<T> currentNode = root;
		Queue<Node<T>> queue = new LinkedList<>();
		ArrayList<T> result = new ArrayList<>();

		queue.add(currentNode);

		while (queue.size() > 0) {
			currentNode = queue.remove();
			result.add(currentNode.value);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		return result;
	}
	
	public ArrayList<T> deapthFirstSearchPreOrder() {
		ArrayList<T> result = new ArrayList<>();
		
		class Traverse {
			Traverse(Node<T> currentNode) {
				result.add(currentNode.value);
				if(currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				if(currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}
		new Traverse(root);
		return result;
	}
	
	public ArrayList<T> deapthFirstSearchPostOrder() {
		ArrayList<T> result = new ArrayList<>();
		
		class Traverse {
			Traverse(Node<T> currentNode) {
				if(currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				if(currentNode.right != null) {
					new Traverse(currentNode.right);
				}
				result.add(currentNode.value);
			}
		}
		
		new Traverse(root);
		return result;
	}
	
	public ArrayList<T> depthFirstSearchInOrder() {
		ArrayList<T> result = new ArrayList<>();
		
		class Traverse {
			Traverse(Node<T> currentNode) {
				if(currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				result.add(currentNode.value);
				if(currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}
		new Traverse(root);
		return result;
	}
	
	/** Size of the BST **/
	public int size() {
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(Node<T> root) {
		/*** Ternary Operator ***/
		return (root == null) ? 0 : this.getSizeRecursive(root.left) + 1 + this.getSizeRecursive(root.right);
	}
}
