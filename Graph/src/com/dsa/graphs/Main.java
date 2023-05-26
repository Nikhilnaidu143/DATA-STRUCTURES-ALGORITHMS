package com.dsa.graphs;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("B", "D");
		graph.addEdge("D", "C");
		graph.printGraph();

//		graph.removeEdge("A", "B");
		graph.removeVertex("D");
		graph.printGraph();

		System.out.println(factorial(5));
		
		System.out.println(isPowerOfFour(16));
	}

	public static int factorial(int num) {
		if (num == 1) {
			return 1;
		}
		return num * factorial(num - 1);
	}

	public static boolean isPowerOfFour(int n) {
		if (n == 1)
			return true;
		if (n % 4 != 0 || n == 0)
			return false;
		return isPowerOfFour(n / 4);
	}

}
