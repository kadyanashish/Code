package lecture6;

import java.awt.FocusTraversalPolicy;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class arrayops {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		/*
		 * int[] arr = takeinput(); display(arr); int maximum = max(arr);
		 * System.out.println("maximum element is :: " + maximum);
		 * System.out.println("Enter the number to be searched ::"); int number
		 * = scn.nextInt(); int result = linearsearch(arr, number);
		 * System.out.println("The number is at" + result + "th position");
		 * reverse(arr); display(arr);
		 */
		System.out.println("Enter the two arrays to check for reverse");
		int[] arr1 = takeinput();
		int[] arr2 = takeinput();
		// boolean check = checkreverse(arr1, arr2);
		// System.out.println(check);
		boolean invcheck = checkinverse(arr1, arr2);
		System.out.println(invcheck);
	}

	public static int[] takeinput() {
		int[] retval = null;
		System.out.println("Enter the size");
		int n = scn.nextInt();
		retval = new int[n];
		for (int i = 0; i < retval.length; i++) {
			System.out.println("Enter" + i + "th ");
			retval[i] = scn.nextInt();
		}
		return retval;
	}

	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");

		}
		System.out.println("end");
	}

	public static int max(int[] arr) {

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int linearsearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (data == arr[i])
				return i;
		}
		return -1;
	}

	public static void reverse(int arr[]) {
		int temp;
		for (int i = 0; i <= arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	public static boolean checkreverse(int[] arr1, int[] arr2) {
		boolean bool = true;
		for (int i = 0; i < arr2.length; i++) {
			if (arr1[i] != arr2[i - 1]) {
				bool = false;
			}
		}
		return bool;
	}

	public static boolean checkinverse(int[] arr1, int[] arr2) {
		boolean bool = true;
		for (int i = 0; i < arr1.length; i++) {
			if (i != arr2[arr1[i]]) {
				bool = false;
			}
		}
		return bool;
	}
	/*
	 * public static int[] getinverse(int[] arr){ int a[]; for (int i = 0; i <
	 * arr.length; i++) { if(i==) {
	 * 
	 * } }
	 */

	/* } */

}