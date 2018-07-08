/*Smallest subarray with sum greater than a given value
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}*/

//SOLUTION IN O(N) :::
package INTERVIEW;

import java.util.ArrayList;

public class smallestsubarraysumgreaterthangivenint {

	public static void main(String[] args) {

		int arr[] = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		int x = 280;

		System.out.println(smallestsubarr(arr, arr.length, 502));
	}

	public static ArrayList<Integer> smallestsubarr(int[] array, int n, int value) {
		int index = -1;
		int minlength = n + 1;
		int start = 0;
		int end = 0;
		int sum = 0;
		while (end < n) {

			while (sum <= value && end < n) {
				sum += array[end];
				end++;
			}

			while (sum > value && start < n) {
				if (end - start < minlength) {
					minlength = end - start;
					index = start;
				}
				sum = sum - array[start];
				start++;

			}

		}

		ArrayList<Integer> re = new ArrayList<>();
		if (index == -1) { // if no such subarray exists
			return re;
		}
		for (int i = index; i < index + minlength; i++) {
			re.add(array[i]);
		}
		System.out.println(minlength);
		return re;
	}

}
