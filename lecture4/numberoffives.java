package lecture4;

import java.util.Scanner;

public class numberoffives {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		int count = 0;
		while (n != 0) {
			int last = n % 10;
			if (last == 5) {
				count++;
			}
			n = n / 10;
		}
		System.out.println("Number of fives are " + count);
	}

}
