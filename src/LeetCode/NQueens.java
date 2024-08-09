package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		char[][] board = new char[n][n];
		
		List<List<String>> ans = new ArrayList<>();
		Solution2 sl = new Solution2();
		sl.solveNQueensHelp(0, board, ans );
		
		for(int i = 0 ; i < 100; i++) {
			
		}
		
		}
	
		
	
}

class Solution2 {
    public void solveNQueensHelp(int row, char board[][], List<List<String>> ans) 
    {
    	
    	if(row == board.length){
    			saveBoard(board, ans);
    			return;
    	}
    	
    	for(int col = 0; col < board[0].length; col++ ) {
    			
    		if(isAllowed(row, col, board)){
    			board[row][col] = 'Q';
    			solveNQueensHelp(row + 1, board, ans);
    			board[row][col] = '.';
    		}
    		
    	}
    	
        
    }

	private void saveBoard(char[][] board, List<List<String>> ans) {
	
		List<String> local_list = new ArrayList<>();
		
		for(int i = 0; i < board.length; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 'Q') {
					sb.append('Q');
				}
				else {
					sb.append('.');
				}
			}
			local_list.add(sb.toString());
		}
			
			ans.add(local_list);
		
		
	}

	private boolean isAllowed(int row, int col, char[][] board) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < board[0].length; i++ ){
			if(board[row][i] == 'Q') {
				return false;
			}
			
		}
		
		for(int i = 0; i < board.length; i++ ){
			if(board[i][col] == 'Q') {
				return false;
			}
			
		}
		
		//Upper Left
		
		int r = row;
		
		for(int c = col; c >= 0 && r >= 0 ; c-- , r--) {
			if(board[r][c] == 'Q') {
				return false;
			}
		}
		
		r = row;
		
		//Bottom right
		for(int c = col; c < board[0].length && r < board.length ; c++ , r++) {
			if(board[r][c] == 'Q') {
				return false;
			}
		}
		
		r = row;
		
		//Upper right
		for(int c = col; c < board[0].length && r >= 0 ; c++ , r--){
			if(board[r][c] == 'Q') {
				return false;
			}
		}
		
		// Bottom left
		r = row;
		for(int c = col; c > 0 && r >  board.length  ; c-- , r++) {
			if(board[r][c] == 'Q') {
				return false;
			}
		}
		
		
		return true;
	}

	
}
