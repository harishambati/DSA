package leetCode;
import java.util.PriorityQueue;

public class HireKWorkers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewSolution s = new NewSolution();
		int[] costs = {17,12,10,2,7,2,11,20,8};
		
		System.out.println(s.totalCost(costs, 3, 4));
	}

}


class NewSolution {
    public long totalCost(int[] costs, int k, int candidates) {
    	int[] visited = new int[costs.length];
        PriorityQueue<Integer> first = new PriorityQueue<Integer>();
        PriorityQueue<Integer> second = new PriorityQueue<Integer>();
        int i = 0;
        int j = costs.length -1;
        int cost = 0;
        while( k > 0)
        {

            while(first.size() < candidates && i < costs.length){
            	if(visited[i] == -1) 
            	{
            		break;
            	}
            	first.add(costs[i]);
                visited[i] = -1;
                i++;
            }
            
            while(second.size() < candidates && j >= 0)
            {
            	if(visited[j] == -1) 
            	{
            		break;
            	}
            	visited[j] = -1;
            	second.add(costs[j]);
                j--;
            }
            

            if(first.size() > 0 && second.size() > 0){

                if(first.peek() > second.peek()){
                    cost = cost + second.poll();
                }

                
                else {
                    cost = cost + first.poll();
                }
            }

            else if(first.size() > 0){
                cost = cost + first.poll();
            }

            else if(second.size() > 0){
                cost = cost + second.poll();
            }


            k--;
        }

            return cost;
    }
}