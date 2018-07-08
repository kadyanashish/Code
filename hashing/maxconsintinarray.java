package hashing;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lecture8.arraylist;

public class maxconsintinarray {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 8, 3, 9, 10, 11, 12, 13, 14, 15, 76, 4, 9, 7 };
		System.out.println(maxconsint(arr));
	}

	public static ArrayList<Integer> maxconsint(int[] array) {

		HashMap<Integer, Boolean> hash = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			int n = array[i];
			int nm1 = n - 1;
			int nm2 = n + 1;
			if (hash.containsKey(nm1)) {
				hash.put(n, false);
			} else {
				hash.put(n, true);
			}
			if (hash.containsKey(nm2)) {
				hash.put(nm2, false);
			}
			System.out.println(hash);

		}
		int size = 0;
		int value = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		Set<Map.Entry<Integer, Boolean>> entries = hash.entrySet();
		for (Map.Entry<Integer, Boolean> entry : entries) {
			if (entry.getValue() == false) {
				continue;
			}

			int seql = 0;
			int seqs = entry.getKey();
			while (hash.containsKey(seqs + seql)) {
				seql++;
			}
			if (seql > size) {
				size = seql;
				value = seqs;
			}
		}
		System.out.println(value);
		System.out.println(size);
		for (int i = value; i < value + size; i++) {
			arr.add(i);
		}
		return arr;
	}
}
