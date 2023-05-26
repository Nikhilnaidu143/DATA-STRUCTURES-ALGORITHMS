package com.dsa.insertion.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSort(int[] array) {
		
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while(j > -1 && temp < array[j]) {
				array[j+1] = array[j];
				array[j] = temp;
				j--;
			}
			System.out.println("Step-" + i + ": " + Arrays.toString(array));
		}
		
		System.out.println("Sorted: " + Arrays.toString(array));
	}

	public static void main(String[] args) {
		System.out.println("Un-sorted: " + Arrays.toString(new int[] { 4, 2, 6, 5, 1, 3 }));
		
		insertionSort(new int[] { 4, 2, 6, 5, 1, 3 });
	}
}
