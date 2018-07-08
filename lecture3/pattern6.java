package lecture3;

import java.util.Scanner;

public class pattern6 {

	public static void main(String[] args) {
		System.out.println("Enter no. of rows");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {

				System.out.print(i);

			}
			System.out.println();
		}
	}

}
