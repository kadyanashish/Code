package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class panagramornot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter a string");
		String s = sc.next();
		System.out.println(panagram(s));
	}

	public static boolean panagram(String s) {
		HashMap<Character, Boolean> pana = new HashMap();
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				st.append((char) (c - 'A' + 'a'));
			} else
				st.append(c);
		}
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if ((c >= 'a' && c <= 'z')) {
				pana.put(st.charAt(i), true);
			}
		}
		if (pana.size() == 26) {
			return true;
		} else {
			return false;
		}
	}
}
