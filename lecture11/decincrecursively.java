package lecture11;

public class decincrecursively {

	public static void main(String[] args) {
		printincdec(5);
		System.out.println("**********************");
		printincdecoddeven(5);
		printincdecoddeven(5);
	}

	public static void printincdec(int n) {
		if (n <= 0) {
			return;
		}
		System.out.println(n);
		printincdec(n - 1);
		System.out.println(n);
	}

	public static void printincdecoddeven(int n) {
		if (n <= 0) {
			return;
		}
		if (n % 2 == 1) {
			System.out.println(n);
		}
		printincdecoddeven(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);
		}
	}
}
