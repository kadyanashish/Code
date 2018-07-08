package lecture2.java;

import java.util.Scanner;

public class summoddevendigitplace {
	public static void main(String[] args) {
		Scanner ssc = new Scanner(System.in);
		int n = ssc.nextInt();
		int i = 0;
		int sumodd = 0, sumeven = 0, last = 0;
		while (n != 0) {
			++i;
			last = n % 10;
			if (i % 2 == 0) {
				sumeven += last;
			} else {
				sumodd += last;
			}
			n /= 10;
		}
		System.out.println(sumodd);
		System.out.println(sumeven);

	}

}
