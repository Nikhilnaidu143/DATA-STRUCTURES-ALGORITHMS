package com.dsa.bubble.sort;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int[] unsortedArray) {
		System.out.println(Arrays.toString(unsortedArray));
		for (int i = 0; i < unsortedArray.length; i++) {
			for (int j = 0; j < unsortedArray.length-1- i; j++) {
				if (unsortedArray[j] > unsortedArray[j+1]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
				} 
			}
		}

		return unsortedArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(bubbleSort(new int[] {2 , 1 , 5 , 6 ,8 ,4 ,3 , 7})));
	}
}
