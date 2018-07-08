package INTERVIEW.nagarrogfg5;

import lecture6.arrayops;
import lecture6.swaparrayelements;

public class zerooneandtwosarraysort {

	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 5, 1, 0, 7, 0, 5, 0, 8, 7 };
		separate(array);
		arrayops.display(array);
	}

	public static void separate(int[] array) {

		int left = 0;
		int size=0;
		int right = array.length - 1;
		while (left <= right) {
			if (array[left] == 0) {
				swaparrayelements.swap(array, left, right);
				left++;
				right--;
			}
			while (array[left] != 0 && left <= right) {
				left++;

			}

		}

	}
}
