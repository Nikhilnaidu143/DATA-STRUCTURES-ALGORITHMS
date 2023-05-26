package com.dsa.stack;

public class Stack{
	
	private Node top;
	private int height = 0;
	
	public Stack(int value) {
		Node newNode = new Node(value);
		top = newNode;
		height = 1;
	}
	
	class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public void getTop() {
		System.out.println("top : " + top.value);
	}
	
	public void getHeight() {
		System.out.println("height : " + height);
	}
	
	public void printStack() {
		if(top == null && height < 1) {
			System.out.println("stack is empty...!");
			return;
		}
		Node temp = top;
		while(temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		if(height == 0 && top == null) {
			top = newNode;
		}
		newNode.next = top;
		top = newNode;
		height++;
	}
	
	public Node pop() {
		if(top == null && height < 1) return null;
		
		Node temp = top;
		top = top.next;
		temp.next = null;
		height--;
		return temp;
	}
	
	public boolean isEmpty() {
		return (top == null && height < 1) ? true : false;
	}
	
	public Integer peek() {
		return top != null ? top.value : null;
	}
	
}
