package lec15;

public class lexispattern {

	public static void main(String[] args) {
lexico(100,0);
	}
	public static void lexico(int end, int current) {
		if (current == end) {
			System.out.println(current);
			return;
		}
		if (current > end) {
			return;
		}
		System.out.println(current);
		for (int i = (current == 0 ? 1 : 0); i <= 9; i++) {
			lexico(end, 10 * current + i);
		}

	}
	
}
