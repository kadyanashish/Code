package lecture6;

import java.util.Scanner;

public class tripletsumsame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Enter the elements of array");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter target");
		int target = sc.nextInt();
		triplet(arr, target);
	}

	public static void triplet(int[] array, int target) {
		int[] three = new int[3];
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				for (int j2 = j + 1; j2 < array.length; j2++) {
					if (array[i] + array[j] + array[j2] == target) {
						System.out.println(array[i] + "" + array[j] + "" + array[j2]);
					}
				}
			}
		}
	}
}
