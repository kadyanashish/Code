package INTERVIEW;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KANAGRAM {

	public static void main(String[] args) {
		System.out.println(kanagram("anagram", "grammar", 0));
		System.out.println(kanagramapproach2("anagram", "grammar", 3));

		System.out.println(kanagramBESTapproach("anagram", "grammar", 1));
	}

	public static boolean kanagram(String s1, String s2, int k) {
		HashMap<Character, Integer> ana = new HashMap();
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			Integer value = ana.get(c);
			if (value == null) {
				value = 1;
			} else {
				value++;
			}
			ana.put(c, value);
		}
		System.out.println(ana);
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			Integer value = ana.get(c);
			if (value == null) {
				value = 1;
			}

			else {
				value--;
			}
			ana.put(c, value);

		}
		System.out.println(ana);
		int check = 0;
		Set<Map.Entry<Character, Integer>> allentries = ana.entrySet();
		for (Map.Entry<Character, Integer> entry : allentries) {
			if (entry.getValue() > 0)
				check++;
		}
		System.out.println(check);
		if (check <= k) {
			return true;
		}
		return false;
	}

	public static boolean kanagramapproach2(String s1, String s2, int k) {// without
		// hashtable , USING HASHARRAY ,,,

		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (int i = 0; i < s1.length(); i++) {

			count1[s1.charAt(i) - 'a'] += 1; // hash array
		}

		/*
		 * for (int i = 0; i < count1.length; i++) {
		 * System.out.print(count1[i]); }
		 */

		for (int i = 0; i < s2.length(); i++) {

			count2[s2.charAt(i) - 'a'] += 1;
		}
		System.out.println();
		/*
		 * for (int i = 0; i < count2.length; i++) {
		 * System.out.print(count2[i]); }
		 */
		int posdiff = 0;
		for (int i = 0; i < count1.length; i++) {
			if (count1[i] > count2[i]) {
				posdiff += count1[i] - count2[i];
			}
		}
		if (posdiff > k) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean kanagramBESTapproach(String s1, String s2, int k) {// without
		// hashtable , USING HASHARRAY ,,,

		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (int i = 0; i < s1.length(); i++) {

			count1[s1.charAt(i) - 'a'] += 1; // hash array
		}

		/*
		 * for (int i = 0; i < count1.length; i++) {
		 * System.out.print(count1[i]); }
		 */
		int count = 0;

		for (int i = 0; i < s2.length(); i++) {
			if (count1[s2.charAt(i) - 'a'] > 0) {
				count1[s2.charAt(i) - 'a'] -= 1;
			} else
				count += 1;
			if (count > k) {
				return false;
			}

		}
		return true;

	}

}
