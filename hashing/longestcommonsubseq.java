/*Q3. Write a Function to find the Increasing Subsequence whose sum is highest in which each number is greater than previous by one in the given array. If the difference is less than or greater than one then it is not considered as subsequence. Print the subsequence array and sum of the subsequence array. Time complexity of program must be O(n).
Input array :- 1 , 2 , 3 , 4 , 5 , 3 , 4 , 5 , 6 , 7 , 9 , 10 , 11 , 12 , 8 , 9 , 10 , 21 , 35 , 36 , 37 , 22
Output :- Longest Subsequence : 35,36,37
    	        	Sum = 108

*/

package hashing;

import java.util.HashMap;

public class longestcommonsubseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] lcs(int[] arr1) {
		HashMap<Integer, Boolean> hash = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {

			hash.put(arr1[i], true);

		}
		
		
		
         
		return arr1;

	}
}
