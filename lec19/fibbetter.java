package lec19;

public class fibbetter {

	public static void main(String[] args) {
System.out.println(fibbtr(10,));
	}

	public static int fibbtr(int n, int[] storage) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		int fib1 = fibbtr(n - 1, storage);
		int fib2 = fibbtr(n - 2, storage);
		int fibn = fib1 + fib2;
		storage[n] = fibn;

		return n;

	}
}
