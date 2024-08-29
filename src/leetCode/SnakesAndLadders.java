package leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] board = {{-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1},
	                {-1,-1,-1,-1,-1,-1},
	                {-1,35,-1,-1,13,-1},
	                {-1,-1,-1,-1,-1,-1},
	                {-1,15,-1,-1,-1,-1}};
	        System.out.println(solve(board));
	}
	
	static int solve(int[][] board){
			
		Collections.reverse(Arrays.asList(board));
		
		Queue<SqPair> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		q.add(new SqPair(1,0));
		
		while(q.size() > 0)
		{
			SqPair temp = q.remove();
			
			for(int i = 1; i < 7; i++){
				
				int next_sq = temp.sq + i;
				RowandColPair new_sq = getRowAndCol(next_sq, board.length);
				if(board[new_sq.row][new_sq.col] != -1) {
					next_sq = board[new_sq.row][new_sq.col];
				}
				if(next_sq == board.length * board.length){
					return temp.moves + 1;
				}
				if(!set.contains(next_sq)){
					set.add(next_sq);
					q.add(new SqPair(next_sq, temp.moves + 1));
				}
				
			}
			
			
			
		}
		
		return -1;
	}

		
	private static RowandColPair getRowAndCol(int square, int n) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        if (r % 2 != 0) {
            c = n - 1 - c;
        }
        return new RowandColPair(r, c);
    }
	
}


class SqPair{
	int sq ;
	int moves;
		
	SqPair(int sq, int moves){
		this.sq = sq;
		this.moves = moves;
		
	}
	
}


class RowandColPair{
	int row ;
	int col;
		
	RowandColPair(int row, int col){
		this.row = row;
		this.col = col;
		
	}
	
}
