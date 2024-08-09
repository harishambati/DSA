package LeetCode;


class GameOfLife {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gameOfLife(board);
	}
	
	
    public static void gameOfLife(int[][] board) {

        int[][] ans = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                
                int neighbours = calculateNeighbours(i, j, board);

                if(board[i][j] == 1){
                    setStatusForLiveCell(i, j, neighbours, ans);
                }

                
                else
                {
                    setStatusForDeadCell(i, j, neighbours, ans);
                }

            }    
        }

    }

    static int calculateNeighbours(int i, int j, int[][] board){
        int ans = 0;
        if( i - 1 >= 0)
        {
            if(j-1 >= 0 && board[i-1][j-1] == 1)
            {
                    ans++;
            }

            if(board[i-1][j] == 1)
            {
                    ans++;
            }

            
            if(j + 1 < board[0].length && board[i-1][j + 1] == 1)
            {   
                    ans++;
            }

        }


        if(i + 1 < board.length)
        {

            if(j- 1 >= 0 && board[i +1][j - 1] == 1)
            {
                    ans++;
            }

            
            if(board[i + 1][j] == 1)
            {
                    ans++;
            }

            
            if(j + 1 < board[0].length && board[i +1][j + 1] == 1)
            {
                    ans++;
            }

        }

        if( j -1 >= 0 && board[i][j-1] == 1){
            ans++;
        }

        
        if( j + 1 < board[0].length && board[i][j+1] == 1){
            ans++;
        }


        return ans;

    }

    static void setStatusForLiveCell(int i, int j, int neighbours, int[][] ans)
    {

        if( neighbours < 2){
            ans[i][j] = 0;
        }

        else if(neighbours > 3){
              ans[i][j] = 0;
        }

        else if(neighbours == 2 || neighbours == 3 ){
            ans[i][j] = 1;
        }

    }

     static void setStatusForDeadCell(int i, int j, int neighbours, int[][] ans)
    {

        if(neighbours == 3)
        {
            ans[i][j] = 1;
        }

        else
        {
            ans[i][j] = 0;
        }



    }



}