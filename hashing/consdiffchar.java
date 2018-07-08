package hashing;

import java.util.HashMap;

public class consdiffchar {

	public static void main(String[] args) {
		System.out.println(maxconschar("abcddeffgklmkno"));
		;
	}

	public static StringBuilder maxconschar(String s) {

		int finalloc = -1;
		int finalsize = 0;
		int loc;
		int size;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			loc = i;
			size = 0;
			HashMap<Character, Integer> hash = new HashMap<>();
			while (hash.get(c) == null) {
				hash.put(c, 1);
				i++;
				size++;
				if (i == s.length()) {
					break;
				}
				c = s.charAt(i);
				if (size > finalsize) {
					finalsize = size;
					finalloc = loc;
				}

			}
			System.out.println(hash);
			i--;

		}
		StringBuilder res = new StringBuilder();
		res.append(s.substring(finalloc, finalloc + finalsize));
		/*for (int i = finalloc; i < finalloc + finalsize; i++) {
			res.append(s.charAt(i));
		}*/
		System.out.println(finalloc);
		System.out.println(finalsize);
		return res;

	}
}
