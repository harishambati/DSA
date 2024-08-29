package leetCode;
import java.util.ArrayList;
import java.util.List;

class ZigZagPath {
	
	
	public static void main(String[] args) {
		
		
		int[] a = {4,3,2,7,8,2,3,1};
		
		for(int i : findDuplicates(a)) {
			System.out.println(i);
		}
		
		
	}
	
	
	
	
	
	
	
    public static List<Integer> findDuplicates(int[] nums) {
      
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if(i != nums[i] -1){
                    int target = nums[i] -1;

                    if(nums[i] == nums[target]){
                        i++;
                    }

                    else{
                        int temp = nums[target];
                        nums[target] = nums[i];
                        nums[i] = target;

                    }



            }

            else{
                i++;
            }
        }

        for(i = 0; i< nums.length; i++){
            if(nums[i] -1!= i){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}