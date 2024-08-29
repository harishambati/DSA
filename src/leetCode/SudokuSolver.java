package leetCode;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 sl = new Solution3();
		sl.solveSudoku();
	}
	
}


class Solution3{
	
	public void solveSudoku() {
	
		char[][] board =  {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		helper(board, 0, 0);
    }

	private void helper(char[][] board, int row, int col)
	{
	
		if(row == board.length) {
			System.out.println(" faf");
			return;
		}
		
		if(board[row][col] == '.')
		{
			
			for(int num = 1 ; num <= 9; num++)
			{
				if(isAllowed(row , col , num, board) ) {
					char temp = (char)(num+'0');  ;
					board[row][col] = temp;
					
					if(col == 8){
						helper(board, row + 1, 0);
					}
					else {
						helper(board, row, col + 1);
					}
					
					board[row][col] = '.';
				}
			}
			
		}
		else {
			
			if(col == 8){
				helper(board, row + 1, 0);
			}
			else {
				helper(board, row, col + 1);
			}
		}
		
		
	}

private boolean isAllowed(int row, int col, int num, char[][] board) {
		
		for(int c = 0; c < 9; c++) {
			if(board[row][c] == (char)(num+'0')) {
				return false;
			}
		}
		
		for(int c = 0; c < 9; c++) {
			if(board[c][col] == (char)(num+'0')) {
				return false;
			}
		}
		
		int smi = row/3 * 3;
		int smj = col/3 * 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[smi + i ][smj+j] == (char)(num+'0')) {
					return false;
				}
			}
		}
				
		
		return true;
	}
	
	
}
