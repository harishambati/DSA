package LeetCode;
import java.util.HashMap;
import java.util.Map;


class SimiliarStrings {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( closeStrings("cabbba", "aabbss"));     
	}
	
	public static boolean closeStrings(String word1, String word2) {
   	 
    	if(word1.length() != word2.length()){
        	return false;
    	}

    	HashMap<Character, Integer> hm1 = new HashMap<>();
    	HashMap<Character, Integer> hm2 = new HashMap<>();

    	for(int i = 0; i < word1.length(); i++){
        	if(hm1.containsKey(word1.charAt(i))){
            	hm1.put(word1.charAt(i), hm1.get(word1.charAt(i)) + 1);
        	}

        	else{
            	hm1.put(word1.charAt(i), 1);
        	}
    	}



    	for(int i = 0; i < word2.length(); i++){
        	if(hm2.containsKey(word2.charAt(i))){
            	hm2.put(word2.charAt(i), hm2.get(word2.charAt(i)) + 1);
        	}

        	else{
            	hm2.put(word2.charAt(i), 1);
        	}
    	}

    	boolean first  = checkFirstOperation(hm1, hm2);

    	if(first == true){
        	return true;
    	}

    	HashMap<Integer, Integer> hm3 = new HashMap<>();
   	 
    	if(!first)
    	{
        	for(Map.Entry i : hm1.entrySet()){

            	if(hm3.containsKey(i.getValue())){
                	hm3.put((Integer) i.getValue(), hm3.get(i.getValue()) + 1);
            	}   	 

            	else{
                	hm3.put((Integer) i.getValue(), 1);
            	}
           	 

        	}
    	}

    	return checkSecondOperation(hm3, hm2);
	}

	public static boolean checkFirstOperation(HashMap<Character, Integer> hm1, HashMap<Character, Integer> hm2){

    	for(Map.Entry i : hm2.entrySet()){
        	if(!(hm1.containsKey(i.getKey()))){
            	return false;
        	}

        	if(hm1.get(i.getKey()) != i.getValue()){
            	return false;
        	}
    	}
        	return true;
	}

	public static boolean checkSecondOperation(HashMap<Integer, Integer> hm3,  HashMap<Character, Integer> hm2){
     	for(Map.Entry i : hm2.entrySet()){
        	if((hm3.containsKey(i.getValue())) && hm3.get(i.getValue()) > 0)
        	{
            	hm3.put((Integer) i.getValue() , hm3.get(i.getValue())- 1);
            	if(hm3.get(i.getValue()) == 0){
                	hm3.remove(i.getValue());
            	}
        	}

        	else {
            	return false;
        	}

      	 
    	}

    	return true;
	}
   	 

}
