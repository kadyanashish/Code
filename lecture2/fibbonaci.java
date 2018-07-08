package lecture2;

import java.util.Scanner;

public class fibbonaci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int first = -1, second = 1, temp = 0, c = 0;

		while (c <= n) {
			c = first + second;
			temp = first;
			first = second;
			second = second + temp;
			if (c <= n)
				System.out.println(c);
			else
				return;
		}

	}
}