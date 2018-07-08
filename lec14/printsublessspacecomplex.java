package lec14;

public class printsublessspacecomplex {

	public static void main(String[] args) {
		printSS("ab", "");
	}

	public static void printSS(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		char cc = str.charAt(0);
		;
		String ros = str.substring(1);
		printSS(ros, osf + "");
		printSS(ros, osf + cc);
	}
}
