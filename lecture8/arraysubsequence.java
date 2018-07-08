package lecture8;

import java.util.*;

public class arraysubsequence {

	public static void main(String[] args) {
		System.out.println(getsubsets(new int[] { 1, 2, 3 }));
	}

	public static ArrayList<ArrayList<Integer>> getsubsets(int[] array) {
		ArrayList<ArrayList<Integer>> retval = new ArrayList<>();
		int counter = 0;
		int range = (int) (Math.pow(2, array.length) - 1);
		while (counter <= range) {
			ArrayList<Integer> inner = new ArrayList<>();
			int operate = counter;
			for (int i = 0; i < array.length; i++) {
				if (operate % 2 == 1) {
					inner.add(array[i]);
				}
				operate /= 2;
			}

			retval.add(inner);
			counter++;
			System.out.println(retval);
		}
		return retval;
	}
}
