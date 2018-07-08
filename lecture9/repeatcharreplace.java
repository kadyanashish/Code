package lecture9;

public class repeatcharreplace {

	public static void main(String[] args) {
		System.out.println(maxfreq("mmbaghgggghjkjhkkhffgfgfccddddd"));
	}

	@SuppressWarnings("null")
	public static StringBuilder maxfreq(String s) {

		StringBuilder s1 = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			s1.append(c);
			++i;
			if (i == s.length()) {
				break;
			}

			while ((s.charAt(i) == c)) {
				++i;
				if (i == s.length()) {
					break;
				}
			}
			--i;

		}
		return s1;
	}
}