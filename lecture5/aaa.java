package lecture5;

import java.util.Scanner;

public class aaa {
	public static void main(String[] args) {
		System.out.println("Enter the number : ");
		Scanner sc = new Scanner(System.in);
	  double n = sc.nextInt();
		System.out.println("Enter the precision : ");
		int precision = sc.nextInt();
		int i = 0;
		double sqroot = 0;
		while (i * i <= n) {
			sqroot = i;
			i++;
		}
		double dec=1,finalans=0;
		for (int j = 0; j < precision; j++) {
			dec/=10;
			sqroot=sqroot+dec;
			while(sqroot*sqroot<=n){
			finalans=sqroot;
			sqroot=sqroot+ dec;
			}
			sqroot=sqroot-dec;
		}
		System.out.println(finalans);
		
}
}