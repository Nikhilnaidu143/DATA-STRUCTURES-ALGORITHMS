package com.binary.search.tree;

public class MyBinaryNode<T extends Comparable<T>> {
	
	//Instance variables
	T data;
	MyBinaryNode<T> left;
	MyBinaryNode<T> right;
	
	/** Constructor **/
	public MyBinaryNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}