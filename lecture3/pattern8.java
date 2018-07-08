package lecture3;

import java.util.Scanner;

public class pattern8 {

	public static void main(String[] args) {
		System.out.println("Enter no. of rows");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int number=1;
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.print(number);
				++number;
			}System.out.println();
		}
	}

}
