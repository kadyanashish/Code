package lecture4;

import java.util.Scanner;

public class fahrenheittocelcius {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter min fahrenheit value");
		int minf = sc.nextInt();
		System.out.println("Enter max fahrenheit value");
		int maxf = sc.nextInt();
		System.out.println("Enter step size");
		int step = sc.nextInt();
		for (int i = minf; i <= maxf; i = i + step) {
			System.out.print(i + "\t");
			System.out.println((int) (((5.0 / 9) * (i - 32))));

		}
	}

}
