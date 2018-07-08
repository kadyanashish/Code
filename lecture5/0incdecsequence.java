package lecture5;

import java.util.Scanner;

public class incdecsequence {

	public static void main(String[] args) {
		System.out.println("Enter how many inputs ::");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter number");
		int previnput = sc.nextInt();
		boolean isgoingdown = true;

		int currinp;
		for (int i = 0; i < n - 1; i++) {

			System.out.println("Enter number ");
			currinp = sc.nextInt();
			if (currinp < previnput && isgoingdown == false) {
				System.out.println("INVALID INPUT");
				return;

			} else if (currinp < previnput) {
				previnput = currinp;
				continue;
			} else if (currinp > previnput) {
				isgoingdown = false;
				previnput = currinp;
			}
		}

	}
}