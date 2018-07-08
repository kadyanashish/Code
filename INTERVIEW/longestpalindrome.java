package INTERVIEW;

import java.util.HashMap;

public class longestpalindrome {

	public static void main(String[] args) {
		System.out.println(longestpalindrome("acnjccbccnknjeihd"));
	}

	public static String longestpalindrome(String s) {
		int low, high;
		int maxsize = 0;
		int start = 0;
		for (int i = 1; i < s.length(); i++) {
			low = i - 1;
			high = i;
			while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
				if ((high - low + 1) > maxsize) {
					maxsize = high - low + 1;
					start = low;
				}
				low--;
				high++;
			}
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
				if ((high - low + 1) > maxsize) {
					maxsize = high - low + 1;
					start = low;
				}
				low--;
				high++;

			}
		}
		System.out.println(start + " " + maxsize);
		String res = "";
		res = s.substring(start, start + maxsize);

		return res;
	}

}
