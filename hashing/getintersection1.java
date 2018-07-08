package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class getintersection1 {

	public static void main(String[] args) {
		int[] arr1 = { 1, 1, 2, 2, 2, 3, 5 };
		int[] arr2 = { 1, 1, 1, 2, 2, 4, 5 };
		int[] arr3 = { 1, 1, 1, 2, 2, 4, 5, -1, -2, -2, -5, 3, -3 };
		System.out.println(getint1(arr1, arr2));
		System.out.println(getint2(arr1, arr2));
		zerosum(arr3);
	}

	public static ArrayList<Integer> getint1(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> hash1 = new HashMap<>();
		HashMap<Integer, Integer> hash2 = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			hash1.put(arr1[i], 1);

		}
		for (int i = 0; i < arr2.length; i++) {
			hash2.put(arr2[i], 1);

		}
		Set<Entry<Integer, Integer>> allentries = hash1.entrySet();
		ArrayList<Integer> res = new ArrayList<>();
		int value = 0;
		for (Entry<Integer, Integer> entry : allentries) {

			value = entry.getKey();
			if (hash2.containsKey(value)) {
				res.add(value);

			}

		}

		return res;
	}

	public static ArrayList<Integer> getint2(int[] arr1, int[] arr2) {// UPDATE
																		// IT
																		// USING
																		// BOOLEAN HASHMAP
		HashMap<Integer, Integer> hash1 = new HashMap<>();
		HashMap<Integer, Integer> hash2 = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {

			Integer value = hash1.get(arr1[i]);
			if (value == null) {
				value = 1;
			} else {
				value += 1;
			}
			hash1.put(arr1[i], value);

		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			if (hash1.get(arr2[i]) == null || hash1.get(arr2[i]) == 0) {
				continue;
			} else {
				int value = hash1.get(arr2[i]);
				res.add(arr2[i]);
				value = value - 1;
				hash1.put(arr2[i], value);
			}

		}

		return res;
	}

	public static void zerosum(int[] arr1) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {

			Integer value = hash.get(arr1[i]);
			if (value == null) {
				value = 1;
			} else {
				value += 1;
			}
			hash.put(arr1[i], value);

		}
		System.out.println(hash);
		Set<Entry<Integer, Integer>> allentries = hash.entrySet();
		ArrayList<Integer> res = new ArrayList<>();
		int value = 0;
		for (Entry<Integer, Integer> entry : allentries) {

			value = entry.getKey();
			Integer value2 = 0 - value;
			if (value < 0 && hash.containsKey(value2)) {
				int max = Math.min(hash.get(value), hash.get(value2));
				for (int i = 0; i < max; i++) {
					System.out.println(value + " " + value2);
				}

			}

		}

	}
}
