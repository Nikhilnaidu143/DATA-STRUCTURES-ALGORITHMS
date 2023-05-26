package com.binary.search.tree;

public class Binary_Search_Tree<T extends Comparable<T>> {
	static MyBinaryNode root;

	/** adding data recursively. **/
	public void add(T data) {
		this.root = insertElementRecursive(root, data);
	}

	/** Assigning data in Binary search tree format. **/
	public MyBinaryNode<T> insertElementRecursive(MyBinaryNode<T> root, T data) {
		if (root == null) {
			root = new MyBinaryNode<T>(data);
			return root;
		}

		if (data.compareTo(root.data) < 0) { // if data is less than the root , then data will assign to the left side
												// of the root.
			root.left = insertElementRecursive(root.left, data);
		} else if (data.compareTo(root.data) > 0) { // if data is greater than the root , then data will assign to the
													// right side of the root.
			root.right = insertElementRecursive(root.right, data);
		}
		return root;
	}

	/** Pre-Order traversal :- root , left , right **/
	public void preOrderTraversal(MyBinaryNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + "  ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	/** In-Order traversal :- left , root , right **/
	public void inOrderTraversal(MyBinaryNode<T> node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.data + "  ");
		inOrderTraversal(node.right);
	}

	/** Post-Order traversal :- left , right , root **/
	public void postOrderTraversal(MyBinaryNode<T> node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + "  ");
	}

	/** Size of the BST **/
	public int size() {
		return this.getSizeRecursive(root);
	}

	public int getSizeRecursive(MyBinaryNode<T> root) {
		/*** Ternary Operator ***/
		return (root == null) ? 0 : this.getSizeRecursive(root.left) + 1 + this.getSizeRecursive(root.right);
	}

	/** Ability to search 63 in the Binary Tree. **/
	public boolean search(T data) {
		return this.searchRecursive(root, data);
	}

	public boolean searchRecursive(MyBinaryNode<T> root, T data) {
		if (root == null) {
			return false;
		} else if (data.compareTo(root.data) == 0) {
			return true;
		} else {
			if (data.compareTo(root.data) < 0) {
				return searchRecursive(root.left, data);
			} else {
				return searchRecursive(root.right, data);
			}
		}
	}

	/** Main Method **/
	public static void main(String[] args) {
		System.out.println("-----------WELCOME TO BINARY-SEARCH-TREE-----------\n");

		// creating object of Binary_Search_Tree class.
		Binary_Search_Tree<Integer> bst = new Binary_Search_Tree<Integer>();

		bst.add(56); //               56
		bst.add(30); //          30        70
		bst.add(70); //       22    40 60      95
		bst.add(22); //     11            65
		bst.add(40); //  3     16      63    67
		bst.add(11);
		bst.add(3);
		bst.add(16);
		bst.add(60);
		bst.add(95);
		bst.add(63);
		bst.add(65);
		bst.add(67);

		System.out.print("Pre-Order Traversal:- ");
		bst.preOrderTraversal(root);

		System.out.print("\n\nIn-Order Traversal:- ");
		bst.inOrderTraversal(root);

		System.out.print("\n\nPost-Order Traversal:- ");
		bst.postOrderTraversal(root);

		System.out.println("\n\nSize of the Binary-Search-Tree :- " + bst.size());
		
		System.out.println("\nSearch result :- " + bst.search(63));
	}
}