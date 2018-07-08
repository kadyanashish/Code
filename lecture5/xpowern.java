package l5;

import java.util.Scanner;

public class xpowern {
	public static void main(String[] args) {
		System.out.println("Enter the number :: ");
		Scanner sn=new Scanner(System.in);
		int x=sn.nextInt();
		System.out.println("Enter the power :: ");
		int n=sn.nextInt();
		int ans=1;
		for (int i = 0; i < n; i++) {
		ans=ans*x;
		}
		System.out.println("answer :: "+ans);
}
}