package leetCode;
import java.util.HashMap;
import java.util.HashSet;

public class StringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sb = new Solution();
		String patter = "he";
		String s = "unit";
		System.out.println(sb.wordPattern(patter, s));
				
	}	

}


class Solution {
    public boolean wordPattern(String pattern, String s) {

        
        HashMap<Character, String> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j < pattern.length() && i < s.length())
        {
            char a = pattern.charAt(j);
            StringBuffer sb = new StringBuffer();

            while(i < s.length()){
                if(s.charAt(i) == ' ')
                {
                    i++;
                    break;
                }
                sb.append(s.charAt(i));
                i++;
            }

            if(hm.containsKey(a) && hm.get(a).equals(sb.toString())){
                j++;
            	continue;
            }
            
            else if(hm.containsKey(a) && !(hm.get(a).equals(sb.toString()))){
                return false;
            }
            

            else if(hs.contains(sb.toString())){
                return false;
               
            }   

            else{
                hm.put(a, sb.toString());
                hs.add(sb.toString());
                j++;
            }

            
           

        }

        if(j >= (pattern.length())  && i >= (s.length() )){
            return true;
        }

        return false;


    }
}