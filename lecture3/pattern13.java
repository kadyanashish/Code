package lecture3;

import java.util.Scanner;

public class pattern13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int space = (n - i - 1) * 2 - 1;
			int number = 1;
			for (int j = 0; j <= i; j++) {
				System.out.print(number + "\t");
				number++;
			}
			for (int j = 0; j < space; j++) {
				System.out.print("\t");
			}
			number -= 1;

			int m = 0;
			if (i == n - 1) { // for the last row we need an extra decrement
								// without any spaces
				number -= 1;
				m = 1; // and one less element for the last row is required
						// hense a increament in value of m which is 0 for other
						// rows.....
			}
			for (int j = m; j <= i; j++) {

				System.out.print(number + "\t");
				number--;
			}
			System.out.println();
		}
	}

}
