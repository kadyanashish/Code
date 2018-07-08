package lecture8;

import java.util.Scanner;

import lecture6.arrayops;

public class bubblesort {

	public static void main(String[] args) {
		int[] arr = { 6,8,3,45,83,67,9,11,34,23,5};
		System.out.println("bubble sorted array ");

	//	bubblesort(arr);
		display(arr);
		System.err.println();
		System.out.println("selection sort");
		selectionsort(arr);
		display(arr);
		System.out.println();
		System.out.println("insertion sort");
		insertionsort(arr);
		display(arr);
		System.out.println();
		System.out.println("Enter the number for binay search");
		Scanner scn = new Scanner(System.in);
		int check = scn.nextInt();
		int n = binarysearch(arr, check);
		System.out.println(n);
	}

	public static void bubblesort(int[] array) {
		int counter = 0;
		while (counter < array.length - 1) {
			for (int i = 0; i < array.length - 1 - counter; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);

				}
			}
			counter++;
			arrayops.display(array);;
		}
	
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void selectionsort(int[] array) {
		int counter = 0;
		while (counter < array.length - 1) {
			for (int i = counter; i < array.length - 1; i++) {
				if (array[counter] > array[i + 1]) {
					swap(array, counter, i + 1);
				}
			}
			counter++;
			arrayops.display(array);
		}

	}

	public static void insertionsort(int[] array) {
		int counter = 0;
		while (counter < array.length - 1) {
			for (int i = counter + 1; i >= 0; i--) {
				if (array[i] < array[i - 1]) {
					swap(array, i, i - 1);
				} else {
					break;

				}
			}
			counter++;
		}
	}

	public static int binarysearch(int[] array, int data) {
		int left = 0, right = array.length - 1, mid = 0;

		while (left <= right) {
			mid = left + right / 2;
			if (data < array[mid]) {
				right = mid - 1;
			} else if (data > array[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}