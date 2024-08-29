package leetCode;
import java.util.HashSet;

class CommonCharcaters {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = 
			{{'a','a','a'},
			 {'A','A','A'},
			 {'a','a','a'}};
		
		System.out.println(exist(grid, "aAaaaAaaA"));
		

	}
	
	
    public static boolean exist(char[][] board, String word) {
        boolean ans = false;
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j])
                {
                    hs.add(i+","+j);
                    ans = dfs(board, i, j, word, 0, hs);
                    hs.remove(i+","+j);
                }

                if(ans == true){
                    break;
                }

               
            }
            if(ans == true){
                break;
            }
        }

        return ans;
    }


    static boolean dfs(char[][] board, int row, int column, String word, int index , HashSet<String> hs){
      
    	 if(index == word.length()){
             return true;
         }
         
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length ){
            return false;
        }

       
        if(word.charAt(index) != board[row][column]){
            //hs.remove(row+","+column);
            return false;
        }

        boolean top = false;

        if((!hs.contains((row-1) + "," +(column)))){
              hs.add((row-1) + "," +(column));
              top =  dfs(board, row -1, column, word, index + 1, hs);
              hs.remove((row-1) + "," +(column));
         
        }
       
        boolean right = false; 
        
        if((!top) && (!hs.contains((row)+","+(column+1)))){
             hs.add((row)+","+(column+1));
            right = dfs(board, row, column + 1, word, index + 1, hs);   
              hs.remove((row)+","+(column+1));
        }

        boolean down = false; 
        
        if(!(top) && !(right) && (!hs.contains((row+1) +","+(column)))){
            hs.add((row+1)+","+column);  
            down = dfs(board, row + 1, column, word, index + 1, hs);
              hs.remove((row+1)+","+(column));  
        }
        
        boolean left = false; 
        
        if(!(top) && !(right) && !(down) && (!hs.contains((row)+","+(column-1)))){
            hs.add((row)+","+(column-1));
            left = dfs(board, row , column - 1, word, index + 1, hs);   
             hs.remove((row)+","+(column-1));
        }


        return top ||  left || right ||down ;

    }
}