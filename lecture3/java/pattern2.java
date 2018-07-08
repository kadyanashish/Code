package lecture3.java

import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		System.out.println("Enter the no. of rows required in the pattern :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int space = 0, m;
		System.out.println("THE REQUIRED PATTERN IS");
		for (int i = 1; i <= n; i++) {
			space = n - i;
			for (int l = 0; l < space; l++) {
				System.out.print(" ");
			}
			m = i;
			for (int j = 0; j < i; j++) {
				System.out.print(m++ + "");
			}
			int value = m - 1;
			for (int b = 0; b < i - 1; b++) {
				System.out.print(--value + "");
			}
			System.out.println();
		}
		int a=0;
		for (int i = n-1; i <=1; i--) {
			space=a++;
			for (int j = 0; j <space; j++) {
				System.out.print(" ");}
			int value=i;
				for (int j2 = 0; j2 <i; j2++) {
					System.out.print(value++);
				}
			
		}
	}
}