package lecture5;

import java.util.Scanner;

public class countdigits {

	public static void main(String[] args) {
		System.out.println("enter a number");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		System.out.println(count);
	}

}
