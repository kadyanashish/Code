package lecture2.java;

import java.util.Scanner;

public class oddevensumindigit {

	public static void main(String[] args) {
		System.out.println("Enter the no till which odd and even nos sum is required");
		Scanner ssc = new Scanner(System.in);
		int n = ssc.nextInt();
		int i;
		int sumodd = 0, sumeven = 0;
while(n!=0){
	i=n%10;
			if (i % 2 == 0) {
				sumeven += i;
			} else {
				sumodd += i;
			}
			n/=10;
}
		System.out.println(sumodd);
		System.out.println(sumeven);

	}

}
