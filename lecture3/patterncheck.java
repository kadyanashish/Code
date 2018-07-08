package lecture3;

import java.util.Scanner;

public class patterncheck {
	public static void main(String[] args) {
		System.out.println("Enter the no. of rows required in the pattern :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int space = 0, m;
		System.out.println("THE REQUIRED PATTERN IS");
		space = n + 1;
		for (int i = 1; i <= n; i++) {
			for (int l = 1; l <= i; l++) {
				System.out.print(l);
			}

			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			int value = i;
			if(space<0){value--;}
			for (int b = value; b >= 1; b--) {
				System.out.print(b);
			}
			space -= 2;
			
			System.out.println();
		}
	}
}