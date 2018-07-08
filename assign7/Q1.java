package assign7;

public class Q1 {

	public static void main(String[] args) {

		System.out.println(sum("d3rgt56yhe56", 0));
		;
	}

	public static int sum(String s, int sum) {
		if (s.length() == 0) {
			return sum;
		}
		char c = (s.charAt(0));
		if (c >= '1' && c <= '9') {
			sum += (int) (c) - 48; // 48 is the ascii value of zero
		}

		String ros = s.substring(1);

		return sum(ros, sum);
	}
}
