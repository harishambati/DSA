package leetCode;
import java.util.LinkedList;
import java.util.Queue;

class MaxAreaIsland {
	
	
	public static void main(String[] args) {
		
		int[][] grid = 	{
						{0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		MaxAreaIsland m = new MaxAreaIsland();
		System.out.println(m.maxAreaOfIsland(grid));
	}
	
	
	
	
    public  int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0 ; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {   
                if(grid[i][j] == 1)
                {
                  Math.max(ans, helper(grid , i, j));
                }
            }
        }

        return ans;
    }


     int  helper(int[][] grid ,int row, int col) 
    {
        int ans = 0;
        Queue<Pair> q  = new LinkedList();
        q.add(new Pair(row,col));
        grid[row][col] = -1;    


        while(q.size() > 0)
        {
            Pair temp = q.remove();
            ans++;
            int i = temp.i;
            int j = temp.j;

            //top

            if( i - 1 >= 0 && grid[i-1][j] == 1 ){
                q.add(new Pair(i-1,j));
                grid[i-1][j] = -1;
            }

            //right
            if( j + 1 <  grid[0].length && grid[i][j +1] == 1){
                q.add(new Pair(i,j +1));
                grid[i][j + 1] = -1;
            }

            // bottom
              if( i + 1  <  grid.length && grid[i+1][j] == 1){
                q.add(new Pair(i+1,j));
                grid[i+1][j] = -1;
            }

             //left
            if( j - 1 >= 0 && grid[i][j  - 1] == 1){
                q.add(new Pair(i,j - 1));
                grid[i][j - 1] = -1;
            }
            
        }

        return ans;

    }

    class Pair{

        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}