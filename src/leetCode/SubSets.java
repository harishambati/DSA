package leetCode;
import java.util.ArrayList;
import java.util.List;

class SubSets {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = {1,2,3};	
		subsets(temp);
		
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> helper = new ArrayList<>(); 
        List<List<Integer>> answer = new ArrayList<>();
        subsetHelper(nums, helper, answer, 0 );
        
            return answer;
    
    }

   public static void  subsetHelper(int[] nums, List<Integer> helper, List<List<Integer>> answer, int start ){

        if(start == nums.length )
        {
          
        	List<Integer> tm = new ArrayList<>(helper);
        	for(int i : tm) {
        		System.out.println(i);
        	}
        	
        	
            answer.add(tm);
            return;
        }

        for(int i = start ; i < nums.length; i++){
            helper.add(nums[i]);
            subsetHelper(nums, helper, answer, i + 1 );
            helper.remove(helper.size() - 1);
           // subsetHelper(nums, helper, answer, i  + 1);
        }

    }


}
