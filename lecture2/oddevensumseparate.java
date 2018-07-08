package lecture2;

import java.util.Scanner;

public class oddevensumseparate {

	public static void main(String[] args) {
		System.out.println("Enter the no till which odd and even nos sum is required");
		Scanner ssc = new Scanner(System.in);
		int n = ssc.nextInt();
		int sumodd = 0, sumeven = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				sumeven += i;
			} else {
				sumodd += i;
			}
		}
		System.out.println("The sum of odd noumbers = " + sumodd + " and sum of even numbers =" + sumeven);

	}
}
