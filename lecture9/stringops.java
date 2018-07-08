package lecture9;

public class stringops {

	public static void main(String[] args) {
		printsubstring("hello");
		System.out.println(ispalindrome("mellm"));
		System.out.println(ispalindromesubstring("abba"));
		System.out.println(togglecase("bhvcgvSDFSdctfcf"));
		System.out.println(mp1("asdhjsg"));
		System.out.println(mp2("acf"));
		subsequence("abc");
	}

	public static void printsubstring(String s) {

		for (int i = s.length(); i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.println(s.substring(j, i));
			}
		}
	}

	public static boolean ispalindrome(String s) {
		boolean b = true;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}

		}

		return b;
	}

	public static int ispalindromesubstring(String s) {
		int counter = 0;
		for (int i = s.length(); i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (ispalindrome(s.substring(j, i))) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static String togglecase(String s) {
		String s1 = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 'a' && s.charAt(i) < 'z') {
				s1 += (char)(s.charAt(i) - 'a' + 'A');
			} else {
				s1 += (char)(s.charAt(i) - 'A' + 'a');
			}

		}

		return s1;
	}

	public static String mp1(String s) {
		String s1 = "";

		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				s1 = s1 + (char) (s.charAt(i) - 1);
			} else {
				s1 = s1 + (char) (s.charAt(i) + 1);
			}

		}
		return s1;
	}

	public static String mp2(String s) {
		String s1 = "";
		for (int i = 0; i < s.length() - 1; i++) {
			int diff = s.charAt(i + 1) - s.charAt(i);
			s1 = s1 + (char) (s.charAt(i));
			s1 = s1 + diff;
		}
		s1 = s1 + s.charAt(s.length() - 1);
		return s1;
	}

	public static void subsequence(String s) {
		String s1 = "";
		int count = (int) Math.pow(2, s.length());

		for (int i = count - 1; i >= 0; i--) {
			int pos = 0;
			int j = i;

			while (j > 0) {
				if ((j / 2 == 0 && j % 2 > 1) || (j / 2 == 0 && j % 2 == 1))
					s1 = s1 + (char) (s.charAt(pos));
				j /= 2;
				pos++;

				count++;
			}
			System.out.println(s1);
		}
	}
}
