package lecture2.java;

import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows required in the pattern");
		int n = sc.nextInt();
		System.out.println("THE REQUIRED PATTERN IS :: ");
		int i = 1, j, k = 0;
		while (i <= n) {
			j = 0;
			while (j < i) {
				System.out.print(++k+"  ");
				j++;
			}
			System.out.println("\n");
			i++;
		}
	}

}
