package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

	public static void main(String[] args) {
		
		String senate = "RRR";
		System.out.println(predictPartyVictory(senate));

	}

	 public static String predictPartyVictory(String senate) {
	        
	        Queue<Character> q = new LinkedList<>();
	        for(char c: senate.toCharArray()){
	            q.add(c);
	        }
	       
	        int radiant = 0;
	        int dire = 0;
	        while(q.size() > 1){
	            char temp = q.remove();
	            
	            if(radiant == q.size()){
	                return "Radiant";
	            }
	        

	             if(dire == q.size()){
	                return "Dire";
	            }

	            if(temp == 'R')
	            {
	                if(dire > 0){
	                    dire--;
	                }

	                else{
	                    q.add('R');
	                    radiant++;
	                }

	            }


	            if(temp == 'D')
	            {
	                if(radiant > 0){
	                    radiant--;
	                }

	                else{
	                    q.add('D');
	                    dire++;
	                }

	            }


	        }


	        char temp2 = q.remove();

	        return temp2 == 'R' ? "Radiant" : "Dire";

	    }
}
