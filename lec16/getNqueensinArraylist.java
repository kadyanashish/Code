package lec16;

import java.util.ArrayList;

public class getNqueensinArraylist {

	public static void main(String[] args) {
		System.out.println(getnqueens(4));
	}

	public static ArrayList<String> getnqueens(int N) {
		boolean[][] b = new boolean[N][N];
		return getnqueens2(0, b);

	}

	public static ArrayList<String> getnqueens2(int row, boolean[][] b) {
		if (row == b.length) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < b.length; i++) {
			ArrayList<String> recresult = new ArrayList<>();
			if (isitsafetpq(b, row, i)) {
				b[row][i] = true;
				recresult = getnqueens2(row + 1, b);
				for (int j = 0; j < recresult.size(); j++) {
					result.add("{" + row + "," + i + "}" + recresult.get(j));
				}
				b[row][i] = false;

			}
		}
		return result;
	}

	public static boolean isitsafetpq(boolean[][] board, int row2check, int col2check) {

		for (int i = row2check; i >= 0; i--) {
			if (board[i][col2check]) {
				return false;
			}
		}
		for (int i = col2check, j = row2check; i >= 0 && j >= 0; i--, j--) {
			if (board[j][i]) {
				return false;
			}
		}
		for (int i = col2check, j = row2check; i < board.length && j >= 0; i++, j--) {
			if (board[j][i]) {
				return false;
			}
		}
		return true;
	}

}
