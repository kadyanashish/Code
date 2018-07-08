package lecture9;

public class maxfreqcharconsecutive {

	public static void main(String[] args) {
		System.out.println(maxfreq("bsjhjkddhjbddd"));
	}

	public static String maxfreq(String s) {
		char maxfreq = ' ';
		String s1 = "";
		int max = 0;
		int count = 0;
		char c = s.charAt(0);
		maxfreq = c ;
		max = 1;
		for (int i = 0; i < s.length(); i++) {

			c = s.charAt(i);
			count = 1;
			++i;
			if (i == s.length()) {
				break;
			}

			while ((s.charAt(i) == c)) {
				++count;

				if (count > max) {
					max = count;
					maxfreq = s.charAt(i);
				}
				i++;
				if (i == s.length()) {
					break;
				}

			}
			i--;

		}
		s1 += (char) (maxfreq);
		s1 += (max);
		return s1;
	}
}