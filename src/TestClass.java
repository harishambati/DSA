import java.util.PriorityQueue;
import java.util.Queue;

class Solution 

{
	
	public static void main(String[] args) {
		
	}
	
	
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Pair> elgible_projects = new PriorityQueue<>((p1,p2) -> Integer.compare(p1.capital,p2.capital));
        for(int i = 0 ; i < capital.length; i++){
            elgible_projects.add(new Pair(profits[i], capital[i]));
        }
        int profit = 0;
        Queue<Pair> profitable_projects = new PriorityQueue<>((p1,p2) -> Integer.compare(p2.profit,p1.profit));
    
       
       
        int curr_capital = w;
        
        while(k > 0 && elgible_projects.size() > 0){

            while(elgible_projects.peek().capital <= curr_capital)
            {
                    profitable_projects.add(elgible_projects.poll());
            }
            if(profitable_projects.size() == 0){
                break;
            }
            Pair removed = profitable_projects.poll();
            curr_capital +=   removed.profit;
            profit += removed.profit; 
            k--;

        }

        return profit;

    
    }

    class Pair{

    int profit;
    int capital;

    Pair(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
    }

}