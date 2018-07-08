package lecture9;

import java.util.ArrayList;

public class intersectionarray {

	public static void main(String[] args) {
		System.out.println(intersection(new int[] { 2, 6, 2, 1, 4, 7, 2, 9, 0 }, new int[] { 1, 3, 5, 2 }));
	}

	public static ArrayList<Integer> intersection(int[] array1, int[] array2) {
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		ArrayList<Integer> arrtemp = new ArrayList<Integer>();
		if (array1.length < array2.length) {
			for (int i = 0; i < array2.length; i++) {
				arrtemp.add(array2[i]);
			}
			int flag = 0;
			for (int i = 0; i < array1.length; i++) {
				flag = 0;
				for (int j = 0; j < arrtemp.size(); j++) {
					if (array1[i] == arrtemp.get(j)) {
						arrli.add(array1[i]);
						arrtemp.remove(j);
						break;
					}

				}
			}
		} else {
			for (int i = 0; i < array1.length; i++) {
				arrtemp.add(array1[i]);
			}
			int flag = 0;
			for (int i = 0; i < array2.length; i++) {
				flag = 0;
				for (int j = 0; j < arrtemp.size(); j++) {
					if (array2[i] == arrtemp.get(j)) {
						arrli.add(array1[i]);
						arrtemp.remove(j);
						break;
					}

				}
			}
		}

		return arrli;
	}
}
