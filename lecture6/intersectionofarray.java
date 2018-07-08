package lecture6;

import java.util.ArrayList;
import java.util.Scanner;

public class intersectionofarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array 1");
		int n = sc.nextInt();
		System.out.println("Enter the elements of array 1");
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("Enter the size of array 2");
		int m = sc.nextInt();
		System.out.println("Enter the elements of array 2");
		int[] arr2 = new int[m];
		for (int j = 0; j < m; j++) {
			arr2[j] = sc.nextInt();
		}
		System.out.println(intersection(arr1, arr2));
	}

	public static ArrayList<Integer> intersection(int[] array1, int[] array2) {
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		if (array1.length <= array2.length) {
			for (int i = 0; i < array1.length; i++) {
				for (int j = 0; j < array2.length; j++) {
					if (array1[i] == array2[j]) {
						arrli.add(array1[i]);
						break;
					}
				}
			}
		} else if (array1.length > array2.length) {
			for (int i = 0; i < array2.length; i++) {
				for (int j = 0; j < array1.length; j++) {
					if (array2[i] == array1[j]) {
						arrli.add(array2[i]);
						break;
					}
				}
			}
		}

		return arrli;
	}
}
