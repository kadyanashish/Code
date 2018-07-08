package lec13;

import java.util.ArrayList;

import lecture8.arraylist;

public class subsequsingandpermutationrec {

	public static void main(String[] args) {
		System.out.println(getss1("abc"));
		System.out.println(getsswithascii("dkbg"));
		System.out.println(per("dbg"));
	}

	public static ArrayList<String> getss(String s) {
		if (s.equals("")) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;

		}
		char cc = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> getresult = getss(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < getresult.size(); i++) {
			myresult.add("" + getresult.get(i));
			myresult.add(cc + getresult.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> getsswithascii(String s) {
		if (s.equals("")) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;

		}
		char cc = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> getresult = getsswithascii(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < getresult.size(); i++) {
			myresult.add("" + getresult.get(i));
			myresult.add(cc + getresult.get(i));
			myresult.add((int) cc + getresult.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> permutations(String s) {
		if (s.equals("")) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;

		}
		char cc = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> getresult = permutations(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < getresult.size(); i++) {
			String substring = getresult.get(i);
			for (int j = 0; j <= substring.length(); j++) {// Significance of
															// equalto sign
															// ##########$#@%$^@@@@@@@@@@@#%$#@$^
				String ss = substring.substring(0, j) + cc + substring.substring(j);
				myresult.add(ss);
			}
		}
		return myresult;
	}

	public static ArrayList<String> getss1(String s) {
		if (s.equals("")) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char c = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> res = getss(ros);
		ArrayList<String> rv = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {

			rv.add("" + res.get(i));
			rv.add(c + res.get(i));

		}
		return rv;
	}

	public static ArrayList<String> per(String s) {
		if (s.equals("")) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		char c = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> res = per(ros);
		ArrayList<String> rv = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j <= res.get(i).length(); j++) {
				rv.add(res.get(i).substring(0, j) + c + res.get(i).substring(j));
			}
		}
		return rv;
	}
}
