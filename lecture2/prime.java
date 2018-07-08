package lecture2;

import java.util.Scanner;

public class prime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = scn.nextInt();
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				System.out.println("not prime");
				return;
			}
		}
		System.out.println("Prime");

	}
}
