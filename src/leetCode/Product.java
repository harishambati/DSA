package leetCode;



public class Product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] max = {2,3,-2,4};
		System.out.println(maxProduct(max));
	}
    public static int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int left = nums[0];
        int right = nums[nums.length -1];
        int max = Math.max(left, right);
        for(int i = 1; i < nums.length; i++)
        {
            
            left = left * nums[i] ;
            right = right * nums[nums.length - 1 - i];
            if(left == 0){
                left = 1;
            }
            max = Math.max(left, max);
            max = Math.max(max, right);
        }
       
       return max;
    }

}