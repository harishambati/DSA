package LeetCode;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b = "A man, a plan, a canal: Panama";
		//String b = "0P";
		
		
		System.out.println(isPalindrome(b));
		
	}	

	
	
	public static boolean isPalindrome(String s) {
        
        
	    
        StringBuilder sb = new StringBuilder();

        for(char  c : s.toCharArray() ){{
            if((c <= 65 && c >= 90) || (c <= 97 && c >= 122) || ((c <= 48 && c >= 57) ) ){
                sb.append(c);
            }
        }}
        String temp = s.toLowerCase();
        int i = 0;
        int j = sb.toString().length() -1;
        String b = temp;
        while(i<=j)
        {
            char c = b.charAt(i);
            char d = b.charAt(j);


            if(c == d)
            {
                i++;
                j--;
            }

            else{
                return false;
            }
            
        }

        return true;   
    }
	
	
}
