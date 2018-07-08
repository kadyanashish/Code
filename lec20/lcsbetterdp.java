package lec20;

public class lcsbetterdp {

	public static void main(String[] args) {
		String s1 = "wsdjfkjfdsl";
		String s2 = "skjjdhflaj";
		System.out.println(lcs(s1, s2));
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];
		System.out.println(lcsbetter(s1, s2, storage));
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int f1 = lcs(s1, s2.substring(1));
			int f2 = lcs(s1.substring(1), s2);
			rv = Math.max(f1, f2);

		}

		return rv;

	}

	public static int lcsbetter(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcsbetter(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = lcsbetter(s1, s2.substring(1), storage);
			int f2 = lcsbetter(s1.substring(1), s2, storage);
			rv = Math.max(f1, f2);

		}
		storage[s1.length()][s2.length()] = rv;
		return rv;

	}
}
