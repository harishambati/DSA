package LeetCode;
import java.util.Stack;

public class MaxRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights  = {4,2,0,3,2,5};
		System.out.println(getMaxRectangleArea(heights));
	}

	private static int getMaxRectangleArea(int[] heights) {
		
		Stack<Integer> idx = new Stack<>();
		Stack<Integer> height = new Stack<>();
			
		int i = 0;
		int ans = Integer.MIN_VALUE;
		idx.push(i);
		height.push(heights[0]);
		i++;
		while(i < heights.length && !idx.isEmpty() && !height.isEmpty())
		{
		
			if(height.peek() <=  heights[i]) {
					int index = i;
					if(height.peek() >= heights[i]) {
						index = idx.peek();
					}
					
				
					idx.push(index);
					height.push(heights[i]);
					i++;
			}
			
			else{
				
				int last_index = idx.pop();
				int last_height = height.pop();
				ans = Math.max(calculateArea(last_index, last_height, i), ans);
				
				if(idx.isEmpty())
				{
				
					if(heights[i] == 0){
							idx.removeAllElements();
							height.removeAllElements();
							i++;
							continue;
					}
					int index = i;
					if(last_height >= heights[i]) {
						index = last_index;
					}
					
				
					idx.push(index);
					height.push(heights[i]);
					i++;
				}
			}
		}
		
		while(!idx.isEmpty() && !height.isEmpty()) {
			int last_index = idx.pop();
			int last_height = height.pop();
			ans = Math.max(calculateArea(last_index, last_height, i), ans);
		}
		
		return ans;
	}

	private static int calculateArea(int last_index, int last_height, int curr_index ) {
		
		return  last_height * (curr_index - last_index);

	}
		
}
