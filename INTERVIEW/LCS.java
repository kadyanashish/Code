package INTERVIEW;

public class LCS {

	public static void main(String[] args) {

		System.out.println(LCSiter("aaabbss", "aab"));
	}

	public static int LCSiter(String s1, String s2) {
		int[] rv = new int[s1.length() + 2];

		int diag = rv.length - 1;
		if (s1.length() > s2.length()) {

			rv[diag] = 0;

			for (int i = s2.length() - 1; i >= 0; i--) {

				for (int j = s1.length() - 1; j >= 0; j--) {
					if (s1.charAt(j) == s2.charAt(i)) {
						int temp = 1 + rv[diag];
						rv[diag] = rv[j];
						rv[j] = temp;
					} else {
						int temp = Math.max(rv[j], rv[j + 1]);
						rv[diag] = rv[j];
						rv[j] = temp;
					}

				}

			}

		}
		return rv[0];

	}

}
