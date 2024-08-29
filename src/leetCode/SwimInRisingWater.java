package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class SwimInRisingWater {
	
	public static void main(String[] args) {
		int[][]grid = {{10,12,4,6},{9,11,3,5},{1,7,13,8},{2,0,15,14}};
		System.out.println(	swimInWater2(grid));
	}
	


    public static int swimInWater2(int[][] grid) 
    {
         Queue<Node> ps = new PriorityQueue<>((p1,p2) -> Integer.compare(p1.cost, p2.cost));
        int[][] cost = new int[grid.length][grid.length];
        for(int[] m : cost){
            Arrays.fill(m,Integer.MAX_VALUE);
        }
        //int[][] vis = new int[grid.length][grid.length];
        cost[0][0] = grid[0][0];
        ps.add(new Node(0,0,0));
        while(ps.size() > 0){

            Node removed = ps.remove();
            int row = removed.row;
            int col = removed.col;
            int curr_cost = cost[row][col];
            grid[row][col] = -1;
            

            if( row - 1 >= 0 && grid[row -1][col] != -1){

                int local_cost = 0;
                if(grid[row -1][col] > curr_cost){
                    local_cost = grid[row -1][col] -  curr_cost;
                }

                if(cost[row-1][col] > (curr_cost + local_cost)){
                    cost[row-1][col] = curr_cost + local_cost;
                    ps.add(new Node(curr_cost + local_cost , row - 1, col));
                }                

            }

            
            if( col  + 1 <  grid.length && grid[row][col +1] != -1){

                int local_cost = 0;
                if(grid[row][col + 1] >curr_cost){
                	 local_cost = grid[row][col + 1] -  curr_cost;
                 }

                if(cost[row][col + 1] > (curr_cost + local_cost)){
                    cost[row][col + 1] = curr_cost + local_cost;
                    ps.add(new Node(curr_cost + local_cost , row, col + 1));
                }                

            }


            
            if( row +  1 <  grid.length && grid[row +1 ][col] != -1){

                int local_cost = 0;
                if(grid[row + 1][col] > curr_cost){
                    local_cost = grid[row + 1][col] - curr_cost;
                }

                if(cost[row + 1][col] > (curr_cost + local_cost)){
                    cost[row + 1][col] = curr_cost + local_cost;
                    ps.add(new Node(curr_cost + local_cost , row + 1, col));
                }                

            }


            
            if( col -1 >= 0 && grid[row][col -1] != -1){

                int local_cost = 0;
                if(grid[row][col -1] > curr_cost){
                    local_cost = grid[row][col -1] - curr_cost;
                }

                if(cost[row][col -1] > (curr_cost + local_cost)){
                    cost[row][col -1] = curr_cost + local_cost;
                    ps.add(new Node(curr_cost + local_cost , row, col -1));
                }                

            }



        }
    
    return cost[grid.length-1][grid.length-1];
    }
}




 class Node
 {
    int cost;
    int row;
    int col;
    
    Node(int j, int r, int c){
        cost = j;
        row = r;
        col = c;
    }
 }

