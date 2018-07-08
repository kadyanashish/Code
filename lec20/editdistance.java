package lec20;

public class editdistance {

	public static void main(String[] args) {

		System.out.println(ed("asdasfas", "dfsfasf"));
		int[][] storage = new int[9][8];
		System.out.println(edbtr("asdasfas", "dfsfasf", storage));
	}

	public static int ed(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();

		}
		if (s2.length() == 0) {
			return s1.length();
		}

		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = ed(s1.substring(1), s2.substring(1));
		} else {
			int f1 = 1 + ed(s1.substring(1), s2.substring(1));
			int f2 = 1 + ed(s1.substring(1), s2);
			int f3 = 1 + ed(s1, s2.substring(1));

			rv = Math.min(f1, Math.min(f2, f3));
		}
		return rv;

	}

	public static int edbtr(String s1, String s2, int[][] storage) {
		if (s1.length() == 0) {
			return s2.length();

		}
		if (s2.length() == 0) {
			return s1.length();
		}
		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = ed(s1.substring(1), s2.substring(1));
		} else {
			int f1 = 1 + edbtr(s1.substring(1), s2.substring(1), storage);
			int f2 = 1 + edbtr(s1.substring(1), s2, storage);
			int f3 = 1 + edbtr(s1, s2.substring(1), storage);

			rv = Math.min(f1, Math.min(f2, f3));
		}
		storage[s1.length()][s2.length()] = rv;
		return rv;

	}
}
