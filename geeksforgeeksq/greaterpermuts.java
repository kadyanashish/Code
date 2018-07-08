/*Count natural numbers whose all permutation are greater than that number
There are some natural number whose all permutation is greater than or equal to that number eg. 123, whose all the permutation (123, 231, 321) are greater than or equal to 123.

Given a natural number n, the task is to count all such number from 1 to n.

Examples:

Input : n = 15.
Output : 14
1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 
13, 14, 15 are the numbers whose all 
permutation is greater than the number
itself. So, output 14.

Input : n = 100.
Output : 54
We strongly recommend that you click here and code it yourself first, before moving on to the solution.

A simple solution is to run a loop from 1 to n and for every number check if its digits are in non-decreasing order or not.

An efficient solution is based on below observations.

Observation 1: From 1 to 9, all number have this property. So, for n <= 9, output n.
Observation 2: The number whose all permutation is greater than or equal to that number have all their digits in increasing order.

The idea is to push all the number from 1 to 9. Now, pop the top element, say topel and try to make number whose digits are in increasing order and the first digit is topel. To make such numbers, the second digit can be from topel%10 to 9. If this number is less than n, increment the count and push the number in the stack, else ignore.*/
package geeksforgeeksq;

import java.util.LinkedList;

public class greaterpermuts {

	public static void main(String[] args) {
		System.out.println(greaterpermut(15));
	}

	public static int greaterpermut(int n) {
		int res = 0;

		for (int i = 1; i <= 9; i++) {
			LinkedList<Integer> stack = new LinkedList<>();
			if (i < n) {
				stack.addFirst(i);
				res++;
				System.out.println(i);
			}

			while (!stack.isEmpty()) {

				int check = stack.getFirst();
				stack.removeFirst();
				for (int j = check % 10; j <= 9; j++) {
					int no = check * 10 + j;
			
					if (no <= n) {
						stack.addFirst(no);
						res++;
						System.out.print(no + "  ");

					}

				}
			}

		}

		return res;
	}
}
