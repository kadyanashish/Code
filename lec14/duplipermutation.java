package lec14;

public class duplipermutation {

	public static void main(String[] args) {
		permutations("abac", "");
	}

	public static void permutations(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		boolean[] dupli = new boolean[26];
		for (int i = 0; i < str.length(); i++) {

			char cc = str.charAt(i);

			if (dupli[cc - 'a'] == false) {
				String ros = str.substring(0, i) + str.substring(i + 1);
				permutations(ros, osf + cc);
				dupli[cc - 'a'] = true;
			}
		}

	}
}
