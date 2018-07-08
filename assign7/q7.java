package assign7;

public class q7 {

	public static void main(String[] args) {
		System.out.println(appendatlast("xcvfxcsxxdfxwexxxvx", "", 0));
	}

	public static String appendatlast(String s1, String s2, int count) {
		if (s1.length() == 0) {
			for (int i = 0; i < count; i++) {
				s2 += 'x';
			}
			return s2;

		}

		String ros;
		String ans = "";

		char ch = s1.charAt(0);
		if (ch != 'x') {
			ros = s1.substring(1);
			ans = s2 + ch;

		} else {
			ans = s2; // always remember to update ans,if not updated we will
						// have empty in s2;
			count++;
			ros = s1.substring(1);
		}

		return appendatlast(ros, ans, count);
	}
}
