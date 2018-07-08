package lecture4;

import java.util.Scanner;

public class loweruppercase {

	public static void main(String[] args) {
		System.out.println("Enter the character :: ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		int i;
		for (i = 'A'; i <'Z'; i++) {
			if (i == ch) {

				System.out.println("U");
				return;
			}
		}
		for (i = 97; i < 123; i++) {
			if (i == ch) {
				System.out.println("L");
				return;
			}

		}
		System.out.println("I");

	}
}
