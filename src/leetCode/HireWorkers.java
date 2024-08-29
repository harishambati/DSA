package leetCode;
import java.util.PriorityQueue;

class HireWorkers {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] costs = {17,12,10,2,7,2,11,20,8};
		System.out.println(totalCost(costs, 3, 4));
	}

	
	public static long totalCost(int[] costs, int k, int candidates) {
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int first_pointer = 0;

        while( first_pointer < candidates ){
            heap.add(costs[first_pointer]);
            first_pointer++;
        }

        int second_pointer = costs.length -1;
        first_pointer--;

        int count = 1;
        while(count <= candidates && second_pointer != first_pointer){
            heap.add(costs[second_pointer]);
            second_pointer--;
            count++;
        }

        for(int i = 1; i <= k; i++){
            ans = ans + heap.poll();
        }

        return ans;
    }
}