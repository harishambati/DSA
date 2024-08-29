package leetCode;


class JumpGame2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums  = {2,3,1,1,4};
		System.out.println(jump(nums));
	}
	
    public static  int jump(int[] nums) {
        return getSteps(0, nums);
    }


    public static int getSteps(int index, int[] nums)
    {
        if(index >= nums.length -1)
        {
            return 0;
        }

        int range = index + nums[index];

        int next_index = -1;
        int element = -1;


        for(int j = index + 1; j <= range; j++){
            if(nums[j] > element){
                element = nums[j];
                next_index = j;
            }

            else if(nums[j] == element && next_index < j){
                next_index = j;   
            }
        }


        return getSteps(next_index, nums) + 1;

    }
}
