
public class Minesweeper {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int k = Integer.parseInt(args[2]);
		
		int [][] board = new int[m][n];
		
		int mines = 0;
		while (mines < k) {
			int i = (int) (Math.random()*m);
			int j = (int) (Math.random()*n);
			if (board[i][j] == 0) {
				mines++;
				board[i][j] = -1;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != -1) {
					try {if (board[i-1][j-1] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i-1][j] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i-1][j+1] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i][j-1] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i][j] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i][j+1] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i+1][j-1] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i+1][j] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}
					try {if (board[i+1][j+1] == -1) board[i][j] += 1;}catch (ArrayIndexOutOfBoundsException e){}		
					
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == -1) System.out.print("*  ");
				else System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}

	}

}
