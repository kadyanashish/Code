package lecture3;

import java.util.Scanner;

public class pattern10 {
	public static void main(String[] args) {
		System.out.println("Enter the no. of rows required in the pattern :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int space = 0;
		System.out.println("THE REQUIRED PATTERN IS");
		System.out.println(1);
		for (int i = 2; i <= n; i++) {
			space = i - 2;
			System.out.print(i);
			for (int j = 0; j < space; j++) {
				System.out.print(0);

			}
			System.out.println(i);
		}
	}
}