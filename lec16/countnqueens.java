package lec16;

public class getnqueens {

	public static void main(String[] args) {
		System.out.println(countnqueens(4));
	}

	public static int countnqueens(int N) {
		boolean[][] b = new boolean[N][N];
		int count = countnqueens2(0, b);
		return count;
	}

	public static int countnqueens2(int row, boolean[][] b) {
		if (row == b.length) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i < b.length; i++) {
			if (isitsafetpq(b, row, i)) {
				b[row][i] = true;
				count += countnqueens2(row + 1, b);
				b[row][i] = false;
			}
		}
		return count;

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