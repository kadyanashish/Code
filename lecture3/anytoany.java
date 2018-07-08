package lecture3;

import java.util.Scanner;

public class anytoany {

	public static void main(String[] args) {
		System.out.println("Enter the source base ::");
		Scanner scn = new Scanner(System.in);
		int source = scn.nextInt();
		System.out.println("Enter the destination base ::");
		int des = scn.nextInt();
		System.out.println("Enter the number :: ");
		int n = scn.nextInt();
		int ans = 0, i = 1, rem;
		while (n != 0) {
			rem = n % des;
			ans = rem * i + ans;
			i = i * source;
			n = n / des;
		}
		System.out.println(ans);
	}

}
