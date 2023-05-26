package com.dsa.quick.sort;

import java.util.Arrays;

public class QuickSort {

	public static int pivot(int[] array, int pivotIndex, int rightIndex) {
		int swapIndex = pivotIndex;

		for (int i = pivotIndex + 1; i <= rightIndex; i++) {
			if (array[i] < array[pivotIndex]) {
				swapIndex++;
				swap(array, swapIndex, i);
			}
		}
		swap(array, pivotIndex, swapIndex);

		return swapIndex;
	}

	public static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	public static void quickSort(int[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int pivotIndex = pivot(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, rightIndex);
		}
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void main(String[] args) {

		int[] array = { 4, 6, 1, 7, 3, 2, 5 };

		quickSort(array);

		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
}
