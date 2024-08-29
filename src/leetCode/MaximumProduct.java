package leetCode;
import java.util.Arrays;

public class MaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3,-1,3,5,-6,-6,-1,6,-3,-5,1,0,-6,-5,0,-2,6,1,0,5};
		
		System.out.println(maxProduct(nums));
	}
    public static int maxProduct(int[] nums) {
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        

      return   helper(nums.length - 2, nums, nums[nums.length -1], dp);
    }



      static int helper(int idx, int[] nums, int product, int[] dp){


            if(idx < 0){
                return product;
            }

           if( dp[idx] != -1)
           {
                return dp[idx];
           }
            
            int new_product = product;

            if(nums[idx] <= 0 || product <= 0){

                int old_sub = helper(idx -1, nums, product * nums[idx], dp);
                new_product  = Math.max(new_product, old_sub);

                int new_sub = helper(idx - 1, nums, nums[idx], dp);
                new_product  = Math.max(new_product, new_sub);

                 dp[idx] = new_sub;


            }

            {
                int new_sub = helper(idx -1, nums, product * nums[idx], dp);

                  new_product  = Math.max(new_product, new_sub);
                  dp[idx] = new_sub;
            }

           

            return new_product;
        }


}