package lecture3;

import java.util.Scanner;

public class fibbonacipattern {
  public static void main(String[] args) {
		System.out.println("Enter no. of rows required ::");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int first, second;
int temp;
		first = -1;
		second = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
		
				temp = first;
				first = second;
				second = temp + second;
				System.out.print(second + "  ");
			}
			System.out.println();
		}
	}

}
