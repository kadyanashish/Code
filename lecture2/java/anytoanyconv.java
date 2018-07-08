package lecture2.java;

import java.util.Scanner;

public class anytoanyconv {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int source = sc.nextInt();
		int des = sc.nextInt();
		int n = sc.nextInt();
		int i = 1, rem, ans = 0, ans1 = 0;
		while (n != 0) {
			rem = n % 10;
			ans = rem * i + ans;
			i = i * source;
			n = n / 10;
		}
		i = 1;
		while (ans != 0) {
			rem = ans % des;
			ans1 = i * rem + ans1;
			i = i * 10;
			ans = ans / des;

		}
		System.out.print(ans1);
	}

}
