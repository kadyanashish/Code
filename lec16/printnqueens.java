package lec16;

public class printnqueens {

	public static void main(String[] args) {
		pnqueens(7);
	}

	public static void pnqueens(int N) {
		boolean[][] b = new boolean[N][N];
		countnqueens2(0, b, "");

	}

	public static void countnqueens2(int row, boolean[][] b, String s) {
		if (row == b.length) {
			System.out.println(s + " END");
			return;
		}
		int count = 0;
		for (int i = 0; i < b.length; i++) {
			if (isitsafetpq(b, row, i)) {
				b[row][i] = true;
				countnqueens2(row + 1, b, s + "{" + row + "," + i + "}");
				b[row][i] = false;

			}
		}
		return;
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
