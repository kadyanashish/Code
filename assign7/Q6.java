package assign7;

public class Q6 {

	public static void main(String[] args) {

		System.out.println(removedupli("aaajdkkkfjdhhp", ""));
	}

	public static String removedupli(String s1, String s2) {
		if (s1.length() == 1) {
			return s2 + s1.charAt(0);

		}
		String ros;
		String ans = "";

		char ch = s1.charAt(0);
		while (s1.charAt(0) == s1.charAt(1)) {
			s1 = s1.substring(1);
		}
		ans = s2 + s1.charAt(0); // we add in s2 and not in ans .....
		ros = s1.substring(1);

		return removedupli(ros, ans);
	}
}
