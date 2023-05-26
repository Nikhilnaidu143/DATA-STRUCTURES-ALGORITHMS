package com.dsa.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();

		hashTable.set("nails", 1000);
		hashTable.set("nails", 100);
		hashTable.set("nails", 10);
		hashTable.set("nails", 2);
		hashTable.set("bolts", 500);
		hashTable.set("marker", 10);
		hashTable.set("shoes", 10);

		hashTable.printHashTable();

		System.out.println(hashTable.get("nails"));

		System.out.println(hashTable.keys());

		int[] arr1 = { 1, 3, 5 };
		int[] arr2 = { 2, 4, 6 };
		System.out.println(itemInCommonHashMap(arr1, arr2));

		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 10)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 7)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 3)));
		System.out.println(Arrays.toString(twoSum(new int[] {}, 0)));

		System.out.println(Arrays.toString(subarraySum(new int[] { 1, 2, 3, 4, 5 }, 9)));
		
		
		HashMapLinkedList hs = new HashMapLinkedList();
		hs.put(1, 1);
		hs.put(2, 2);
		hs.put(3, 3);
		hs.put(35, 3);
		
		System.out.println(hs.get(3));
		hs.remove(1);
		hs.printHashTable();
	}

	// interview question: return true if two arrays have common number and false if
	// don't have common number
	// efficient way : Time Complexity : O(n)
	public static boolean itemInCommonHashMap(int[] arr1, int[] arr2) {
		HashMap<Integer, Boolean> hashMap = new HashMap<>();

		for (int i : arr1) {
			hashMap.put(i, true);
		}

		for (int j : arr2) {
			if (hashMap.get(j) != null) {
				return true;
			}
		}
		return false;
	}

	// interview question: return true if two arrays have common number and false if
	// don't have common number
	// In-efficient way : Time Complexity : O(n^2)
	public static boolean itemInCommonNormal(int[] arr1, int[] arr2) {
		for (int i : arr1) {
			for (int j : arr2) {
				if (i == j) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Interview Question
	 * 
	 * Problem: Given an array of integers nums and a target integer target, find
	 * the indices of two numbers in the array that add up to the target.
	 **/
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int needNum = target - num;
			if (map.containsKey(needNum)) {
				return new int[] { map.get(needNum), i };
			} else {
				map.put(num, i);
			}
		}

		return new int[] {};
	}

	/**
	 * Interview Question
	 * 
	 * Given an array of integers nums and a target integer target, write a method
	 * called subarraySum that finds the indices of a contiguous subarray in nums
	 * that add up to the target sum using a hash table (HashMap).
	 * 
	 * Your function should take two arguments:
	 * 
	 * nums: an array of integers representing the input array
	 * 
	 * target: an integer representing the target sum
	 * 
	 * 
	 * Your function should return a list of two integers representing the starting
	 * and ending indices of the subarray that adds up to the target sum. If there
	 * is no such subarray, your function should return an empty list.
	 * 
	 **/
	public static int[] subarraySum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, -1);
		int currentSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];
			if (map.containsKey(currentSum - target)) {
				return new int[] { map.get(currentSum - target) + 1, i };
			} else {
				map.put(currentSum, i);
			}
		}
		return new int[] {};
	}
}
