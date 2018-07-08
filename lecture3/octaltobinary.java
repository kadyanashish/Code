package lecture3;

import java.util.Scanner;

public class octaltobinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1, rem, ans = 0,ans1=0;
		while (n != 0) {
			rem = n % 10;
			ans = rem * i + ans;
			i = i * 8;
			n = n / 10;
		}
		i=1;
		while (ans!= 0)
		{
			rem = ans % 2;
			ans1 = i * rem + ans1;
			i = i * 10;
			ans = ans / 2;

		}
		System.out.print(ans1);
	}

}
