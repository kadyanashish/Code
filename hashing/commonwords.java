




package hashing;

import java.util.HashMap;

public class commonwords {

	public static void main(String[] args) {
		StringBuilder res = commonwords("how are you ", "how is are");
		System.out.println(res);
	}

	public static StringBuilder commonwords(String s1, String s2) {
		StringBuilder rv = new StringBuilder();

		HashMap<StringBuilder, Integer> hash = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			StringBuilder s = new StringBuilder();
			while (c != ' ') {
				s.append(c);
				i++;
				if (i == s1.length()) {
					break;
				}
				c = s1.charAt(i);

			}
			System.out.print(s);
			hash.put(s, 1);
		}
		System.out.println(hash);

		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			StringBuilder s = new StringBuilder();
			while(c != ' ') {

				s.append(c);
				i++;
				if (i == s2.length()) {
					break;
				}
				c = s2.charAt(i);

			}
			System.out.print(s);
			if (hash.containsKey(s)) {
				rv.append(s);
				System.out.println(rv);
			}

		}
		return rv;

	}
}
