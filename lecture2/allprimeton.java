package lecture2;

import java.util.Scanner;

public class allprimeton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 2; i <= n; i++) {
			int flag = 1;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = 0;
					break;
				}

			}
			if (flag != 0) {
				System.out.println(i);
			}

		}
	}

}
