package leetCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class WordsSeparate {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		list.add("aaa");
		
		
		
		System.out.println(wordBreak("aaaaaaa", list));
		
		
	}
	
	
	
    public static boolean wordBreak(String s, List<String> wordDict) {
      HashSet<String> hs = new HashSet<>();

      for(String i: wordDict){
        hs.add(i);
    }

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < s.length(); i++)
    {
        sb.append(s.charAt(i));

        if(hs.contains(sb.toString())){
            sb = new StringBuffer();
        }
    }

    if(sb.isEmpty()){
        return true;
    }
      
      return false;
      
    }
}