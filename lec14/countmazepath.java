package lec14;

import java.util.ArrayList;

public class countmazepath {

	public static void main(String[] args) {
		System.out.println(countmazepath(2, 2, 0, 0));
		System.out.println(returnmazepath(2, 2, 0, 0));
		preturnmazepath(2, 2, 0, 0, "");

	}

	public static int countmazepath(int endr, int endc, int currow, int curcol) {
		if (endr == currow && endc == curcol) {
			return 1;
		}
		if (currow > endr || curcol > endc) {
			return 0;
		}
		int myresul;
		int h = countmazepath(endr, endc, currow, curcol + 1);
		int v = countmazepath(endr, endc, currow + 1, curcol);
		myresul = h + v;
		return myresul;
	}

	public static ArrayList<String> returnmazepath(int endr, int endc, int currow, int curcol) {
		if (endr == currow && endc == curcol) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (currow > endr || curcol > endc) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
		ArrayList<String> myresul = new ArrayList<>();
		ArrayList<String> h = returnmazepath(endr, endc, currow, curcol + 1);
		ArrayList<String> v = returnmazepath(endr, endc, currow + 1, curcol);
		for (int i = 0; i < h.size(); i++) {
			myresul.add("h" + h.get(i));
		}
		for (int i = 0; i < v.size(); i++) {
			myresul.add("v" + v.get(i));
		}
		return myresul;
	}

	public static void preturnmazepath(int endr, int endc, int currow, int curcol, String s) {
		if (endr == currow && endc == curcol) {
			System.out.println(s);
			return;
		}
		if (currow > endr || curcol > endc) {
			return;
		}

		preturnmazepath(endr, endc, currow, curcol + 1, s + "h");
		preturnmazepath(endr, endc, currow + 1, curcol, s + "v");
		preturnmazepath(endr, endc, currow + 1, curcol + 1, s + "d");

	}
}
