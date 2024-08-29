package leetCode;

import java.util.Arrays;

public class BurstingBallons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 4, 3, 5, 6, 7, 8};
		int n = nums.length;
		int[][] dp = new int[nums.length][n + 1];
		for(int[] p : dp) {
			Arrays.fill(p, -1);
		}
		
		System.out.println(helper(nums, n, 0, dp));
	}

	static int helper(int[] nums, int n, int b, int[][] dp) 
	{
		
		if(n == 0) 
		{
			return 0;
		}
		
		int ans = -1;
		
		
		for(int i = 0 ; i < nums.length; i++ )
		{
				if(nums[i] == -1) {
					continue;
				}
					
				int temp = nums[i] * getLeft(nums, i) * getRight(nums,i);
				int temp_num = nums[i];
				nums[i] = -1;
				int score = helper(nums, n-1, i, dp);
				nums[i] = temp_num;
				
				ans = Math.max(ans, score + temp);
		}
		
		dp[b][n] = ans;
		
		return ans;
		
	}

	
	private static int getLeft(int[] nums, int i) {
		i--;
		while(i >= 0) {
			if(nums[i] != -1) {
				return nums[i];
			}
			i--;
		}
		
		return i < 0 ? 1 : nums[i];
	}

	private static int getRight(int[] nums, int i) {
		i++;
		while(i < nums.length) {
			if(nums[i] != -1) {
				return nums[i];
			}
			i++;
		}

		return i == nums.length ? 1 : nums[i];
	}
	
}
