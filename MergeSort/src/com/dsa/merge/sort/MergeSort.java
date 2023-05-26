package com.dsa.merge.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] originalArray = { 2, 3, 6, 8, 1, 5, 7, 4 };
		
		System.out.println("Original Array: " + Arrays.toString(originalArray));
		System.out.println("Sorted Array: " + Arrays.toString(mergeSort(originalArray)));
	}

	public static int[] mergeSort(int[] array) {
		if (array.length == 1)
			return array;

		int midIndex = array.length / 2;

		int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
		int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

		return merge(left, right);
	}

	public static int[] merge(int left[], int[] right) {
		int[] combined = new int[left.length + right.length];
		int combinedIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				combined[combinedIndex] = left[leftIndex];
				combinedIndex++;
				leftIndex++;
			} else {
				combined[combinedIndex] = right[rightIndex];
				combinedIndex++;
				rightIndex++;
			}
		}

		while (leftIndex < left.length) {
			combined[combinedIndex] = left[leftIndex];
			combinedIndex++;
			leftIndex++;
		}
		while (rightIndex < right.length) {
			combined[combinedIndex] = right[rightIndex];
			combinedIndex++;
			rightIndex++;
		}
		return combined;
	}
}
