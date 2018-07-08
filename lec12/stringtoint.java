package lec12;

public class stringtoint {

	public static void main(String[] args) {
		System.out.println(stringtointcon("1435", 0));
	}

	public static int stringtointcon(String s, int count) {
		if (s.length() == 0) {
			int charAt(s.length() - 1);
		}
		int j = stringtointcon(s.substring(0, s.length() - 1), count);

	}
}
