package lecture4;

import java.util.Scanner;

public class armstrongcheck {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();

		System.out.println(isArmstrong(N));
	}

	public static boolean isArmstrong(int n) {
		boolean retVal = false;

		int count = 0, last = 1, arm = 0, value = 1;
		int temp = n;
		while (temp != 0) {
			++count;
			temp /= 10;
		}
		int temp2 = n;
		while (temp2 != 0) {
			last = temp2 % 10;
			value = 1;
			for (int i = 0; i < count; i++) {
				value *= last;
			}
			arm = arm + value;
			temp2 = temp2 / 10;
		}
		if (arm == n) {
			retVal = true;

		}
		return retVal;
	}

}
