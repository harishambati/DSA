package leetCode;



public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String s1 = "AAAABBBB";
		
		String s1 = "AAAABBBB";
		
		System.out.println(helper(s1));
	}
	
	static boolean helper(String s1) 
	{
		int alice = 0;
		int bob = 0;
		
		int i = 0;
		int k = 0;
		while(i < s1.length()) 
		{	
			
			if(s1.charAt(i) != 'A') 
			{

			
			
			int j = i + 1;
			
			while(j < s1.length() && s1.charAt(j) == 'A')
			{
				
				j++;
			}
			
			if( j - i > 2) {
				alice += j -i - 2;
			}
			
			i = j;	
			
			}
			
			
			if(s1.charAt(i) == 'B') 
			{
				if(s1.charAt(i) != 'B') 
				{
						i++;
						continue;
				}
				
				
				int j = i + 1;
				
				while(j < s1.length() && s1.charAt(j) == 'B')
				{
					
					j++;
				}
				
				if( j - i > 2) {
					bob += j -i - 2;
				}
				
				i = j;	
			}
			
			
			
		}
		i = 0;
		while(i < s1.length()) 
		{	
			
			
			
		}
		
		System.out.println(alice);
		System.out.println(bob);
		if(alice > bob) {
			return true;
		}
		
		return false;
		
	}
	
	
	
	
}
