package INTERVIEW;

import lecture6.swaparrayelements;

public class sort012 {

	public static void main(String[] args) {
		int[] array = { 0, 0, 0, 1, 2, 1, 2, 1, 2, 0, 0, 0 };
		sort012better(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void sort012(int[] array) {
		int zero = -1;
		int two = array.length;

		for (int j = 0; j < two; j++) {
			System.out.println("value of j is" + j);
			while (array[j] == 0 || array[j] == 2 && zero < j) {
				System.out.println("value of j is" + j);

				if (array[j] == 0) {
					swaparrayelements.swap(array, zero + 1, j);
					zero += 1;
					continue;
				}
				if (array[j] == 2) {
					swaparrayelements.swap(array, two - 1, j);
					two -= 1;
				}

			}
		}

	}

	public static void sort012better(int[] a) {
		int zero = 0;
		int two = a.length - 1;
		int i = 0;
		while (i <= two) {

			if (a[i] == 0) {
				swaparrayelements.swap(a, i, zero);
				i++;
				zero++;
				continue;
			}
			if (a[i] == 1) {
				i++;
				continue;
			}
			if (a[i] == 2) {
				swaparrayelements.swap(a, i, two);
				// i++;
				two--;

				continue;
			}

		}
	}
}
