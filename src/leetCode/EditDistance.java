package leetCode;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String word1 = "horse";
		String word2 = "ros";
//    	String word1 = "intention"; 
//		String word2 = "execution";
		
		int[][] dp = new int[word1.length()][word2.length()];
		
		for(int[] dp2 : dp) {
			Arrays.fill(dp2, -1);
		}
		
		System.out.println(editDistance(word1.length() -1, word2.length() -1, word1, word2, dp));

	}

	
	public static int editDistance(int i ,int j, String s1, String s2, int[][] dp)
	{
		
		if(i == -1 && j == -1) {
				return 0;
		}
		
		if(i == -1 && j != -1){
			return j + 1;
		}
		
		if(j == -1 && i != -1) {
			return i + 1;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int ans = Integer.MAX_VALUE;
		if(s1.charAt(i) == s2.charAt(j)){
			ans = editDistance(i - 1, j - 1, s1, s2, dp);
		}
		
		
		int add_char = editDistance(i, j -1, s1, s2, dp) + 1;
		ans = Math.min(ans, add_char);
		int replace = editDistance(i - 1 , j -1, s1, s2, dp) + 1;
		ans = Math.min(ans, replace);
		int delete = editDistance(i -1, j, s1, s2, dp) + 1; 
		ans = Math.min(ans, delete);
		
		dp[i][j] = ans;
		return ans;
		
	}
	
	
	
	
	
}
