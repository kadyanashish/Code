package lecture5;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		char ch = '\0';
		int N1 = 0, N2 = 0, output = 0;
		while (ch != 'x') {
			ch = scn.next().charAt(0);
			if (ch == '*') {
				N1 = scn.nextInt();
				N2 = scn.nextInt();
				System.out.println(N1 * N2);
				continue;
			}
			if (ch == '+') {
				N1 = scn.nextInt();
				N2 = scn.nextInt();
				System.out.println(N1 + N2);
				continue;
			}
			if (ch == '-') {
				N1 = scn.nextInt();
				N2 = scn.nextInt();
				System.out.println(N1 - N2);
				continue;
			}
			if (ch == '%') {
				N1 = scn.nextInt();
				N2 = scn.nextInt();
				System.out.println(N1 % N2);
				continue;

			}
			if (ch == '/') {
				N1 = scn.nextInt();
				N2 = scn.nextInt();
				System.out.println(N1 / N2);
				continue;
			}
			if (ch == 'x'||ch == 'X') {
				System.out.println("Invalid operation. Try again.");
                return;
			}
			
		}

	}
}
