
public class Minesweeper2 {

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
		// (0,0)
		if (board[0][0] != -1) {
			if (board[1][0] == -1) board[0][0] += 1;
			if (board[1][1] == -1) board[0][0] += 1;
			if (board[0][1] == -1) board[0][0] += 1;
		}
		// (0,n)
		if (board[0][n-1] != -1) {
			if (board[0][n-2] == -1) board[0][n-1] += 1;
			if (board[1][n-1] == -1) board[0][n-1] += 1;
			if (board[1][n-2] == -1) board[0][n-1] += 1;
		}
		// (m,0)
		if (board[m-1][0] != -1) {
			if (board[m-2][0] == -1) board[m-1][0] += 1;
			if (board[m-2][1] == -1) board[m-1][0] += 1;
			if (board[m-1][1] == -1) board[m-1][0] += 1;
		}
		// (m,n)
		if (board[m-1][n-1] != -1) {
			if (board[m-1][n-2] == -1) board[m-1][n-1] += 1;
			if (board[m-2][n-2] == -1) board[m-1][n-1] += 1;
			if (board[m-2][n-1] == -1) board[m-1][n-1] += 1;
		}
		
		for (int i = 1; i < m-1; i++) {
			if (board[i][0] != -1) {
				if (board[i-1][0] == -1) board[i][0] += 1;
				if (board[i+1][0] == -1) board[i][0] += 1;
				
				if (board[i-1][1] == -1) board[i][0] += 1;
				if (board[i][1] == -1) board[i][0] += 1;
				if (board[i+1][1] == -1) board[i][0] += 1;
			}

			if (board[i][n-1] != -1) {
				if (board[i-1][n-1] == -1) board[i][n-1] += 1;
				if (board[i+1][n-1] == -1) board[i][n-1] += 1;

				if (board[i-1][n-2] == -1) board[i][n-1] += 1;
				if (board[i][n-2] == -1) board[i][n-1] += 1;
				if (board[i+1][n-2] == -1) board[i][n-1] += 1;
			}


		}
		for (int j = 1; j < n-1; j++) {
			if (board[0][j] != -1) {
				if (board[0][j-1] == -1) board[0][j] += 1;
				if (board[0][j+1] == -1) board[0][j] += 1;

				if (board[1][j-1] == -1) board[0][j] += 1;
				if (board[1][j] == -1) board[0][j] += 1;
				if (board[1][j+1] == -1) board[0][j] += 1;
			}

			if (board[m-1][j] != -1) {
				if (board[m-1][j-1] == -1) board[m-1][j] += 1;
				if (board[m-1][j+1] == -1) board[m-1][j] += 1;

				if (board[m-2][j-1] == -1) board[m-1][j] += 1;
				if (board[m-2][j] == -1) board[m-1][j] += 1;
				if (board[m-2][j+1] == -1) board[m-1][j] += 1;
			}
			
		}
		
		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if (board[i][j] != -1) {
					if (board[i-1][j-1] == -1) board[i][j] += 1;
					if (board[i-1][j] == -1) board[i][j] += 1;
					if (board[i-1][j+1] == -1) board[i][j] += 1;

					if (board[i][j-1] == -1) board[i][j] += 1;
					if (board[i][j] == -1) board[i][j] += 1;
					if (board[i][j+1] == -1) board[i][j] += 1;

					if (board[i+1][j-1] == -1) board[i][j] += 1;
					if (board[i+1][j] == -1) board[i][j] += 1;
					if (board[i+1][j+1] == -1) board[i][j] += 1;
					
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
