package lecture11;

public class n_queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[4][4];
		pnq(board, 0, "");

	}

	public static void pnq(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (isitsafeforqueen(board, row, i) == true) {
				board[row][i] = true;
				pnq(board, row + 1, ans + "[" + row + "-" + i + "]");
				board[row][i] = false;
			}
		}
	}

	public static boolean isitsafeforqueen(boolean[][] board, int row, int col) {

		for (int i = 0; i < row; i++) {

			if ((board[i][col] == true)) {
				return false;
			}
		}
		int j = col - 1;
		for (int i = row - 1; i >= 0; i--) {
			if (j >= 0) {
				if (board[i][j] == true) {
					return false;
				}

				j--;
			} else {
				break;
			}
		}
		j = col + 1;

		for (int i = row - 1; i >= 0; i--) {
			if (j < board[0].length) {
				if (board[i][j] == true) {
					return false;
				}

				j++;
			} else {
				break;
			}
		}

		return true;
	}

}
