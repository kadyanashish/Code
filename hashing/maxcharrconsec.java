package hashing;

import java.util.HashMap;

public class maxcharrconsec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public static String maxfrecons(String s) {
		char max = ' ';
		int maxtimes = 0;
		HashMap freq = new HashMap<>();
for (int i = 0; i < s.length(); i++) {
	
	
	if(s.charAt(i)==s.charAt(i-1)){
		freq.put(s.charAt(i), freq.get(s.charAt(i)));
	}
}
		return s;

	}
}
