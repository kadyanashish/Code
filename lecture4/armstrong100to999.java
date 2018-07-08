package lecture4;

import java.util.Scanner;

public class armstrong100to999 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N1 = scn.nextInt();
		int N2 = scn.nextInt();

		printArmstrong(N1, N2);
	}

	public static void printArmstrong(int begin, int end) {
		for (int n = begin; n < end; n++) {
			int  last = 1, arm = 0, value = 1;
			int temp = n;
	
			int temp2 = n;
			while (temp2 != 0) {
				last = temp2 % 10;
				value = 1;
				for (int i = 0; i < 3; i++) {
					value *= last;
				}
				arm = arm + value;
				temp2 = temp2 / 10;
			}
			if (arm == n) {
				System.out.println(arm);
			}
		}
	}

	public static boolean isArmstrong(int num) {
		boolean retVal = false;

		return retVal;
	}
}
