/*
 * Subjective Coding Round:
 * 
 * This round was for 75 minutes and there were three questions which have to be
 * coded using any programming language. First question was given an unsorted
 * array find the Fourth largest in it O(n) time complexity. Second was given
 * and array of 0’s and 1’s sort the array in O(n). Third question was given a
 * string find the longest substring having at most 2 unique characters, if
 * there are multiple longest substrings return them all. Ex: given string
 * “helloworld” then output should contain { “ell”,“llo”,“owo”}. First two
 * questions were quite easy the last one I did with brute force method and
 * there was no time constraint so I did it in O(n2) time.
 * 
 * 
 * After that there was a lunch break and after that they announced the names of
 * people shortlisted for technical interviews
 */

package INTERVIEW.nagarrogfg4;

import java.util.ArrayList;
import java.util.Arrays;

import lecture6.swaparrayelements;

public class q1 {

	public static void main(String[] args) {
		// q1 start
		int[] array = { 4, 4, 6, 3, 6, 8, 4, 5, 7, 5, 3 };

		heapify(array);
		int k = 4; // findind 4th largest
		System.out.println(array[0]);
		for (int i = 0; i < k; i++) {
			remove(array, array.length - i - 1);
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println();
		}
		System.out.println(array[0]);
		// q1 finished

	}

	// q1 functions
	// we do by creating a heap using downheapify instead of upheapify
	// property;;
	public static void heapify(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		for (int i = list.size() / 2 - 1; i >= 0; i--) {

			downheapify(i, array);
		}

	}

	public static void downheapify(int pi, int[] arr) {

		int ci1 = pi * 2 + 1;
		int ci2 = pi * 2 + 2;
		int newp = pi;
		if (ci1 < arr.length && arr[ci1] < arr[newp]) {
			newp = ci1;
		}
		if (ci2 < arr.length && arr[ci2] < arr[newp]) {
			newp = ci2;
		}

		if (newp != pi) {
			swaparrayelements.swap(arr, newp, pi);
			downheapify(newp, arr);
		}

	}

	public static void remove(int[] array, int last) {

		swaparrayelements.swap(array, 0, last);
		array[last] = Integer.MAX_VALUE;
		downheapify(0, array); //downheapify the oth element.

	}

	// q1 funcns end;;
	public static String longeststringat2uniqchar(String s) {

		return null;
	}
}
