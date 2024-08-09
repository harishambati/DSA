package LeetCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CombinationSum3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> l = new ArrayList<>();
		int k = 3;
		int target = 7;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		HashSet<String> global = new HashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();   
		getSum(0, l, k, arr,  target, global, treeSet);
	}

	
	public static void getSum(int sum, List<List<Integer>> l, int k, List<Integer> arr, int target, HashSet<String> global, TreeSet<Integer> treeSet) {
		
		if(arr.size() == k ) {
			if(sum == target) 
			{
				List<Integer> temp = new ArrayList<>();
				
				ArrayList<Integer> copy = new ArrayList<>(arr);
				//Collections.sort(copy);
			//	StringBuilder st = new StringBuilder("");
//				for(int i = 0; i < copy.size(); i++ ) {
//						st.append(copy.get(i));
//				}
					
				String  st = treeSet.toString();
				
		
				
				if(global.contains(st)) {
					return;
				}
				
				for(int i = 0; i < arr.size(); i++)
				{
					temp.add(arr.get(i));
					global.add(st);
					
				}
				l.add(temp);
				
			}
			return;	
		}
		
		for(int i = 1; i <= 9; i++)
		{
			if( !(isValid(arr , i, treeSet))){
				continue;
			}
			
			 arr.add(i);
			 sum = sum + i;
			 getSum(sum, l , k, arr, target, global, treeSet);
			 sum = sum - i;
			 arr.remove(arr.size() -1);
			
		}
		
		
	}


	private static boolean isValid(List<Integer> arr, int i, TreeSet<Integer> treeS) {
		
//		if( global != null &&  (global.contains(i) )) {
//			return false;
//		}
		
//		for(int j = 0; j < arr.size(); j++) {
//			if(arr.get(j) == i) {
//				return false;
//			}
//		}
		
		
		if(treeS.contains(i)) {
			return false;
		}
		
		
		return true;
	}
	
	
	
}


