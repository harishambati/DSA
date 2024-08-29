package leetCode;

import java.util.Arrays;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mississippi";
		String p = "mis*is*p*.";
		int[][] dp = new int[s.length()][p.length()];
		
		for(int[] k : dp) {
			Arrays.fill(k, -1);
		}
			
		System.out.println(helper(s, p, 0, 0,dp));
	}
	
	
	public static boolean helper(String s, String p, int i , int j, int[][] dp) {
		
		if( i == s.length() && j == p.length()){
			return true;
		}
		
		
		if( i == s.length() || j == p.length()){
			return false;
		}
		
		if(dp[i][j] != -1) {
			if(dp[i][j] == 1) {
				return true;
			}
			
			return false;
	}
		
		boolean  x = false;
		
		if(s.charAt(i) != p.charAt(j)  && i == 0) {
			x =  helper(s, p, i , j + 1, dp);
			if(x) {
				dp[i][j] = 1;
				return true;
			}
		}
		
		boolean  w = false;
		if( s.charAt(i) != p.charAt(j)  && p.charAt(j) == '.') {
			w = helper(s, p, i + 1 , j + 1, dp);
			if(w) {
				dp[i][j] = 1;
				return true;
			}
		}
		
		boolean y  = false;

		 if(s.charAt(i) == p.charAt(j)) 
		{
			y  = helper(s, p, i +1 , j + 1, dp);
			if(y) {
				dp[i][j] = 1;
				return true;
			}
		}
		
		boolean z = false;
		if(s.charAt(i) != p.charAt(j)  &&  p.charAt(j) == '*' && i > 0){	
			int next_index = getNextIndex(s, i);
			 z = helper(s, p, next_index , j + 1, dp);
			 if(z) {
					dp[i][j] = 1;
					return true;
				}
		}
		
		if(z) {
			dp[i][j] = 1;
			return true;
		}
		
		dp[i][j] = 0;
	
		return z ;
	}


	private static int getNextIndex(String s, int i) {
		
		int temp = i;
		temp++;
		while( temp < s.length() && s.charAt(i) == s.charAt(temp)){
				temp++;
		}
		
		return temp;
	}

}
