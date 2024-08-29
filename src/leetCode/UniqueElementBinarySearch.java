package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueElementBinarySearch {
	
	
	public static void main(String[] args) {	
		
		int nums[] = {1,2,2};
		Arrays.sort(nums);
		 List<Integer> local   =  new ArrayList<>();
		 List<List<Integer>> ans =  new ArrayList<>();
		 ans.add(local);
		
		getCombos(nums, 0, local, ans);
		System.out.println(ans);
	}	
		
	  static void getCombos(int[] candidates, int index, List<Integer> local, List<List<Integer>> ans) {

	        if (index == candidates.length) {
//	            List<Integer> copy = new ArrayList<>(local);
//	            ans.add(copy);
	            return;
	        }

	        for (int i = index; i < candidates.length; i++) {
	            if (i != index && candidates[i] == candidates[i - 1]) {
	                continue;
	            }


	            local.add(candidates[i]);
	            ans.add(new ArrayList<>(local)) ;
	            getCombos(candidates, i + 1, local, ans);
	            local.remove(local.size() - 1);
	        }

	    }
	
	
}
