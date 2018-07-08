package lecture3;

import java.util.Scanner;

public class pattern12 {
	public static void main(String[] args1) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 1;
		for (int i = 1; i <= n; i++) {
			int space = n - i;
			for (int j = 0; j < space; j++) {
				System.out.print("\t");
			}
			int number = i;
			for (int j = 1; j <= m; j++) {
				System.out.print(number + "\t");
				number++;
			}
			number -= 2;
			for (int j = 1; j < m; j++) {
				System.out.print(number + "\t");
				number--;
			}
			System.out.println();
			m++;
		}
		m = n - 1;
		for (int i = n - 1; i >= 1; i--) {
			int space = n - i;
			for (int j = 0; j < space; j++) {
				System.out.print("\t");
			}
			int number = i;
			for (int j = 1; j <= m; j++) {
				System.out.print(number + "\t");
				number++;
			}
			number -= 2;
			for (int j = 1; j < m; j++) {
				System.out.print(number + "\t");
				number--;
			}
			System.out.println();
			m--;
		}
	}
}
