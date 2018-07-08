package lec14;

import java.util.ArrayList;

public class boardpath {

	public static void main(String[] args) {
		System.out.println(boardpaths(10, 0));
	}

	public static ArrayList<String> boardpaths(int size, int current) {
		if (current == size) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;
		}
		if (current > size) {
			ArrayList<String> baseresult = new ArrayList<>();
			return baseresult;
		}

		ArrayList<String> recresult, myresult = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			recresult = boardpaths(size, current + i);

			for (int j = 0; j < recresult.size(); j++) {
				myresult.add(i + recresult.get(j));
			}
		}
		return myresult;
	}
}
