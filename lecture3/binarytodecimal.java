package lecture3;

import java.util.Scanner;

public class binarytodecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1, rem, ans = 0;
		while (n != 0) {
			rem = n % 10;
			ans = rem * i + ans;
			i = i * 2;
			n = n / 10;
		}
		System.out.print(ans);
	}

}
