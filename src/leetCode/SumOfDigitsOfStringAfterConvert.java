package leetCode;

public class SumOfDigitsOfStringAfterConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s = "iiii";
		 int k = 1;
		 
		 String s2 = "leetcode";
		 int k2 = 2;
		 
		 String s3 = "zbax";
		 int k3 = 2;
		 
		 System.out.println(helper(s, k));
	
		 System.out.println(helper(s2, k2));
			
		 System.out.println(helper(s3, k3));
			
	
	}
	
	
	public static int helper(String s, int k) {
		
		 int sum = 0;
			
			for(int i = 0;  i < s.length(); i++ ) {
				int temp =  (int) s.charAt(i) - 'a' + 1;
				sum +=  temp%10 + temp/10;
			}
	        
			int ans  = sum;
			k--;
			
	        while(k > 0)
			{
				ans = 0;
				while(sum>0) 
	            {
					ans+= sum%10;
					sum = sum/10;
				}
				sum = ans;
				--k;
				
			}
			
			return ans;
			
		
	}
	
	
	

}
