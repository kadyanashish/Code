package sol;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();

		System.out.println(inverse(N));
	}

	public static int inverse(int num) {
		int retVal = 0;

		int n2 = num;
		int inv = 0, count = 1,k=0;
		while (n2 != 0) {
			k++;
			n2 /= 10;
		}
		int actualcount = count;
		while (num!=0) {
			int last = num % 10;
			int i = 1;
			int add = 1;
			for (int j = 0; j < last-1; j++) {
				i *= 10;
			}
add = count * i;
			count++;
			num /= 10;
			inv = inv + add;
		}
		retVal = inv;

		return retVal;
	}
}
