package lecture2.java;

import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		int rem, n2 = 0;
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n != 0) {
			rem = n % 10;
			n2 = n2 * 10 + rem;
			n = n / 10;
		}
		System.out.println(n2);
	}

}
