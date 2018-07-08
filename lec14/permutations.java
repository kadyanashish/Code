package lec14;

public class permutations {

	public static void main(String[] args) {
		// permutations("abc", "");
		pergreater("", "bacd", false);
	}

	public static void permutations(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);

			permutations(ros, osf + cc);

		}

	}

	public static void pergreater(String ans, String ques, boolean b) {
		if (ques.length() == 0 && b == true) {
			System.out.println(ans);
		}

		for (int i = 0; i < ques.length(); i++) {
			char c = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);
			if (b == true) {
				pergreater(ans + c, ros, true);
			}
			if (c == ques.charAt(0)) {
				pergreater(ans + c, ros, false);

			} else if (c > ques.charAt(0)) {
				pergreater(ans + c, ros, true);
			}

		}

	}
	public static void perdupli(String ques,String ans , boolean[] b){
		
		
		
		
		
	}

}
