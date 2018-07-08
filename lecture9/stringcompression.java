package lecture9;

public class stringcompression {

	public static void main(String[] args) {
		System.out.println(compressionprac("dddffggh"));
	}

	public static String compression(String s) {
		char maxfreq = ' ';
		String s1 = "";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			count = 1;
			s1 += (char) (s.charAt(i));
			++i;
			if (i == s.length()) {
				break;
			}

			while ((s.charAt(i) == c)) {
				++count;

				i++;
				if (i == s.length()) {
					break;
				}

			}
			if (count > 1) {
				s1 += (count);
			}
			i--;
		}
		return s1;
	}

	public static String compressionprac(String s) {
		String s1 = "";

		char c = s.charAt(0);
		int count = 1;
		int counter = 0;

		while (counter < s.length()) {

			c = s.charAt(counter);
			count = 1;
			s1 += (s.charAt(counter));
			if (counter + 1 == s.length()) {
				break;
			}

			while (c == s.charAt(counter + 1)) {

				count++;

				counter++;
			}
			if (count >= 2) {
				;
				s1 += count;
			}
			if (counter + 1 == s.length()) {
				break;
			}
			counter++;
		}

		return s1;
	}
}