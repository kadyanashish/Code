package hashing;

import java.util.*;

import lecture8.arraylist;

public class getmaxchar {

	public static void main(String[] args) {
		System.out.println(getmax("dhnjkndjhjjaaaaaahh"));
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(1);
		arr.add(2);
		arr.add(5);
		arr.add(2);
		arr.add(5);
		arr.add(5);
		arr.add(0);

		System.out.println(getunique(arr));
	}

	public static Character getmax(String word) {
		HashMap<Character, Integer> frequency = new HashMap<>();
		for (int i = 0; i < word.length() - 1; i++) {
			char c = word.charAt(i);
			Integer value = frequency.get(c);
			if (value == null) {
				value = 1;
			}
			frequency.put(c, value + 1);
		}
		Set<Map.Entry<Character, Integer>> allentries = frequency.entrySet();
		char c = 0;
		int value = 0;
		for (Map.Entry<Character, Integer> entry : allentries) {
			if (entry.getValue() > value) {
				value = entry.getValue();
				
				c = entry.getKey();
			}
		}
		return c;
	}

	public static ArrayList<Integer> getunique(ArrayList<Integer> arr) {

		HashMap<Integer, Integer> unique = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			unique.put(arr.get(i), 0);
		}
		Set<Integer> set = unique.keySet();
		ArrayList<Integer> array = new ArrayList<>(set);
		return array;
	}
}
