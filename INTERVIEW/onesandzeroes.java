package INTERVIEW;

import lecture6.arrayops;
import lecture6.swaparrayelements;

public class onesandzeroes {

	public static void main(String[] args) {
		int[] array = { 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1 };
		separate(array);
		arrayops.display(array);
	}

	public static void separate(int[] array) {

		int left = 0;
		int right = array.length - 1;
		while (left <= right) {

			if (array[left] == 1 && array[right] == 0) {
				swaparrayelements.swap(array, left, right);
				right--;
				left++;
				arrayops.display(array);
			}
			while (array[left] == 0) {
				left++;

			}
			while (array[right] == 1) {
				right--;
			}

		}
	}
}
