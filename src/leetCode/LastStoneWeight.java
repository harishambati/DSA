package leetCode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {1};
		System.out.println(helper(stones));
	}
	
	
	static int helper(int[] stones) {
		
		
		Queue<Integer> ps = new PriorityQueue<>(Collections.reverseOrder());
		for(int s : stones){
			ps.add(s);
		}
		
		while(ps.size() > 1) 
		{
			int y = ps.remove();
			int x = ps.remove();
			if(x != y) 
			{
				int new_stone = y - x;
				ps.add(new_stone);

			}
							
		}

		
		return ps.size() > 0 ? ps.remove():  0;
		
	}
}
