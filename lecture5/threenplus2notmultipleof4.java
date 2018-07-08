package l5;

import java.util.Scanner;

public class threenplus2notmultipleof4 {

	public static void main(String[] args) {
		int k = 0, flag = 0;
		while (flag != 20) {

			if (((3 * k + 2) % 4) != 0) {
				System.out.println(3 * k + 2);
				flag++;
			}
			k++;
		}
	}

}
