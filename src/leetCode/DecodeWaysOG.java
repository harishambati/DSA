package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DecodeWaysOG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		HashSet<String> hs = new HashSet<String>();
		String s = "11106";
		
		hs.add("1");
		hs.add("2");
		hs.add("3");
		hs.add("4");
		hs.add("5");
		hs.add("6");
		hs.add("7");
		hs.add("8");
		hs.add("9");
		hs.add("10");
		hs.add("11");
		hs.add("12");
		hs.add("13");
		hs.add("14");
		hs.add("15");
		hs.add("16");
		hs.add("17");
		hs.add("18");
		hs.add("19");
		hs.add("20");
		hs.add("21");
		hs.add("22");
		hs.add("24");
		hs.add("23");
		hs.add("25");
		hs.add("26");
		int[] dp = new int[s.length()];
        Arrays.fill(dp, -1); 
		System.out.println(helper(s, 0, hs, dp));
		
		
	}
	
	
	  static int helper(String n, int index, HashSet<String> hs, int[] dp)
		{
			if(index  == n.length()) {
				return 1;
			}

	        if(dp[index]  != -1) {
				return dp[index];
			}

			int ans = 0;
		//	String s = n.substring(index + 1, index + 2);
			
			if(index + 1 <=  n.length() && (Integer.parseInt(n.substring(index , index + 1 )) >= 1 || Integer.parseInt(n.substring(index , index + 1 )) <= 9) ) {
				ans = ans + helper(n, index + 1, hs, dp);
			}
			
//			if(index + 1 <=  n.length() && hs.contains(n.substring(index , index + 1 ))) {
//				ans = ans + helper(n, index + 1, hs, dp);
//			}
		//	String b = n.substring(index + 1, index + 3);
//		
//			if(index + 2 <=  n.length()  && hs.contains(n.substring(index , index + 2)) ) {
//				ans = ans + helper(n,  index + 2 , hs, dp);
//			}
			
			if(index + 2 <=  n.length()  && hs.contains(n.substring(index , index + 2)) ) {
			ans = ans + helper(n,  index + 2 , hs, dp);
			}
			
	        dp[index] = ans;
			return ans;
		}
}
