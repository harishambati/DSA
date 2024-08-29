package leetCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		
		System.out.println(helper(4).toString());
		
		System.out.println(helper(4).toString().equals("[[1],[1,1],[1,2,1],[1,3,3,1]]"));
		
	}
	
	
	static List<List<Integer>> helper(int n){
		List<List<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < n; i++){
			List<Integer> temp_list = new ArrayList<>();
		
			for(int j = 0; j <= i; j++) 
			{
				if( j == 0 || j == i) {
					temp_list.add(1);
				}
				
				else {
					int value = ans.get(i-1).get(j) + ans.get(i-1).get(j -1); 
					temp_list.add(value);
				}
			
			}
			
			ans.add(temp_list);
		}	
		
		return ans;
		
	}

}
