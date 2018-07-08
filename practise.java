import java.util.ArrayList;

public class practise {

	public static void main(String[] args) {
		printPermutation("ans", "");

	}

	public static ArrayList<String> per(String ques, String ans) {
		if (ques.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;

		}
		ArrayList<String> res = new ArrayList<>();

		for (int i = 0; i < ques.length(); i++) {

		}

		return per(ques, ans);

	}

	public static void printPermutation(String ques, String ans) {
		if (ques.equals("")) {
			System.out.println(ans + " ");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation(ros, ans + ch);

		}
	}

}
