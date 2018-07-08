package lecture9;

import java.util.ArrayList;

public class maxfreqchar {

	public static void main(String[] args) {
		System.out.println(maxfreq("jasgchkjasghfjkehefk"));

	}

	public static String maxfreq(String s) {
		ArrayList<Character>  arrli = new ArrayList<Character>();
		for (int i = 0; i <= s.length(); i++) {
			arrli.add(s.charAt(i));
}
}
}