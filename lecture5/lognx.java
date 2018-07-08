package lecture5;

import java.util.Scanner;

public class lognx {
	public static void main(String[] args) {
		System.out.println("Enter the number :: ");
		Scanner sn = new Scanner(System.in);
		int x = sn.nextInt();
		System.out.println("Enter the power :: ");
		int n = sn.nextInt();
		int ans = 0;
		while (x != 1) {
			x = x / n;
			ans++;
		}
		System.out.println("answer :: " + ans);
	}
}