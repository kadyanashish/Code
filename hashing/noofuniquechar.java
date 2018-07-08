package hashing;

import java.util.HashMap;

public class noofuniquechar {

	public static void main(String[] args) {
		System.out.println(uniqchar("BbbccccCCn", 4));
	}

	public static Boolean uniqchar(String s, int k) {
		StringBuilder st = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c > 'A' && c < 'Z') {
				st.append((char) ((c - 'A') + 'a'));

			} else {
				st.append(c);
			}
		}
		System.out.println(st);
		HashMap<Character, Boolean> hash = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			hash.put(st.charAt(i), true);

		}
		if (hash.size() >= k) {
			return true;
		}

		return false;
	}
}
