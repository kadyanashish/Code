package lecture3;

import java.util.Scanner;

public class pascalpattern {

	public static void main(String[] args) {
		System.out.println("Enter the no. of rows required in the pattern :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("THE REQUIRED PATTERN IS");
		for (int i = 0; i < n; i++) {
			int number = 1;
			for (int j = 0; j <= i; j++) {
				System.out.print(number + "\t");
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}

}
