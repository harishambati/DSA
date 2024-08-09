package LeetCode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Maze {
	
	public static void main(String[] args) {
		char[][] maze  = {
						  {'+','+','+'},
						  {'.','.','.'},
						  {'+','+','+'}
						  };
	int[] entrance = {1,0};
	
	System.out.println(nearestExit(maze, entrance));
	
	}
	
    public static int nearestExit(char[][] maze, int[] entrance) {
     

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for(boolean[] k : visited){
            Arrays.fill(k, false);
            
        }

        visited[entrance[0]][entrance[1]] = true;

        int ans = helper(maze, entrance, visited);
        
        return ans;
    }

    static int helper(char[][] maze, int[] entrance,  boolean[][] visited)
    {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(entrance[0], entrance[1], 0));

        while(q.size() > 0 ){
            Pair removed = q.remove();

            int i = removed.i;
            int j = removed.j;
            int level = removed.level;

            if( (i == 0 || i >= maze.length -1 || j == 0 || j >= maze[0].length -1) && level != 0){
                return level;
            }


            if( !((i - 1 ) <0) && maze[i-1][j] != '+' ){
                if(visited[i-1][j] != true){
                     q.add(new Pair(i-1, j, level + 1));     
                    visited[i-1][j] = true;
                }
                
            }

            if( !(( j + 1 ) >= maze[0].length) && maze[i][j + 1] != '+' ){
                if(visited[i][j + 1] != true){
                    q.add(new Pair(i, j + 1, level + 1));
                    visited[i][j + 1] = true;
                }

                
            }
              
            
            if( !(( i + 1 ) >= maze.length) && maze[i + 1][j] != '+' ){
                if(visited[i +1][j] != true){
                q.add(new Pair(i + 1, j , level + 1));
                    visited[i +1][j] = true;
                }
            }

            
            if( !(( j - 1 ) <0 ) && maze[i][j - 1] != '+' ){
               if(visited[i][j - 1] != true){
                    q.add(new Pair(i, j - 1 , level + 1));
                    visited[i][j - 1] = true;
                }
            }
        }

            return -1;

    }


}

class Pair{
    int i = 0;
    int j  = 0;
    int level = 0;

    Pair( int i , int j, int level ){
        this.i = i;
        this.j = j;
        this.level = level;
    }

}