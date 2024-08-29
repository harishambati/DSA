package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordArray = {"hot", "dot", "dog", "lot", "log", "cog"};
   
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
        System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> hs = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        Queue<String> q = new LinkedList<>();

        for(String s : wordList){
            hs.add(s);
        }

        if(!hs.contains(endWord)){
            return 0;
        }

        q.add(beginWord);
        int level = 1;
        while(q.size() > 0)
        {
            int size = q.size();
        	
            
            //visited.add(temp);
            for(int l = 0; l < size; l++ ) 
            {
            	String temp = q.remove();
            	  for(int i = 0 ; i < temp.length(); i++)
                  {

                      for(int j = 'a'; j <= 'z'; j++)
                      {
                          char[] c_array = temp.toCharArray();
                          if((char)j == temp.charAt(i)){
                              continue;
                          }

                          c_array[i] = (char)j;
                          String new_string = String.valueOf(c_array);

                          if(new_string.equals(endWord)){
                              return level + 1;
                          }

                          if(hs.contains(new_string) && !visited.contains(new_string))
                          {
                              q.add(new_string);
                              visited.add(new_string);
                          }
                      }
                  }  
            	
            	
            }
           
            level++;
        }

        return 0;
    }
}