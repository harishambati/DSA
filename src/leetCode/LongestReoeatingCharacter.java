package leetCode;
import java.util.HashMap;
import java.util.Map.Entry;

public class LongestReoeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println(helper("AABABBA", 7));
		
	}
	
	
	static int helper(String s, int k) {
			
		int ans = 1;
		
		
		int left_index = 0 ;
		int right_index = 0 ;
	
		HashMap<Character, Integer> hm = new HashMap<>();		
		hm.put(s.charAt(0), 1 );
		
		while(right_index < s.length()) 
		{
			
			
			
			int length = right_index - left_index + 1;
			
			int freq = getFreq( hm);
			
			if((length - freq)  <= k) {
				ans = Math.max(ans, length);
				
				right_index++;
				updateFreq(s, right_index, hm , 1);
			
			}
			
			else {
				updateFreq(s, left_index, hm , -1);
				left_index ++;
			}
			
		}
		
		
		
		
		return ans;
	}


	private static void updateFreq(String s, int index, HashMap<Character, Integer> hm, int add) {
		if(index >= s.length()) {
			return ;
		}
		
		if(hm.containsKey(s.charAt(index)))
		{	
			int value = hm.get(s.charAt(index)) + add;
			hm.put(s.charAt(index), value );
			
		}
		
		else {
			hm.put(s.charAt(index), add);
		}
	}


	private static int getFreq(HashMap<Character, Integer> hm) {
		int freq = 0;
		for(Entry<Character, Integer> i :  hm.entrySet()) 
		{
			freq = Math.max(i.getValue(), freq);
		}
		
		
		return freq;
	}
	
	
	
	
	
	

}
