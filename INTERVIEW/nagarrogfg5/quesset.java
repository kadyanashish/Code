/*1. Check if binary conversion of given number is palindrome or not. Ex: 6 (0110) is palindrome.
I used a recursive function for binary conversion and then check for palindrome using a loop. Refrain from using inbuilt functions as they wanna check your logic. O(n) time complexity.

2. Separate 0’s and  1’s in that order from a array of only 0’s and 1’s.
I used partition algorithm (Quick Sort) to do the same. O(n) time complexity.

3. One Sentence (string) is given. find out the words, that has length even and greater than equal to 4 (e.g. 4,6,8.. etc.) and separate them with space.
e.g. Given String : “abcd abc abcde abcdef”
Output: “ab cd abc abcde abc def”
I allocated a new string dynamically, and used two for loops to copy one string to another, adding a space at the middle of the word where word length was >=4 and even. O(n^2) time complexity.

It seems easy but it isn’t. I got to know that this can be minimized to O(n) time complexity in the next round.

Practice all types of array and string questions
*/

package INTERVIEW.nagarrogfg5;

public class quesset {

	public static void main(String[] args) {
		greateq4("abcd abcd abc abcde abcdef");
	}

	// Q2
	public static void greateq4(String s) {
		String s1 = "";
		int half = 0;
		for (int i = 0; i < s.length(); i++) {
			String word;
			char c;
			int count = 0;
			int j;
			for (j = i + 1; j < s.length() && c != ' '; j++) {
				c = s.charAt(j);
				count++;

			}
			System.out.println(count);

			if (count >= 4 && count % 2 == 0) {
				half = count / 2;
				half += i;
				count += i;

			}

			s1 += s.substring(0, half) + " " + s.substring(half, count);
			i = j - 1;

		}

		System.out.println(s1);

	}

}
