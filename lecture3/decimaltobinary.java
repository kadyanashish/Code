package lecture3;

import java.util.Scanner;

public class decimaltobinary {

	public static void main(String[] args) {
		System.out.println("Enter a decimal number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int n2 = 0, i = 1, rem = 0;
		while (n != 0)
		{
			rem = n % 2;
			n2 = i * rem + n2;
			i = i * 10;
			n = n / 2;

		}
		System.out.println(n2);
	}

}
