package lec19;

import javax.naming.InitialContext;

public class countmazepathbtr {

	public static void main(String[] args) {
		int[][] storage = new int[4][4];
		//countboardpathbtr.init();
		System.out.println(countmazepath(3, 3, 0, 0, storage));

	}

	public static int countmazepath(int endr, int endc, int currow, int curcol, int[][] storage) {
		if (endr == currow && endc == curcol) {
			return 1;
		}
		if (currow > endr || curcol > endc) {
			return 0;
		}
		if (storage[currow][curcol] != 0) {
			return storage[currow][curcol];
		}
		int myresul;
		int h = countmazepath(endr, endc, currow, curcol + 1, storage);
		int v = countmazepath(endr, endc, currow + 1, curcol, storage);
		myresul = h + v;
		storage[currow][curcol] = myresul;
		return myresul;
	}
}
