package leetCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public class Itinery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		System.out.println(helper(tickets));
		String[][] tickets2 = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
		System.out.println(helper(tickets2));
		
	}
	
	
	static List<String> helper(String[][] tickets){
		List<String> ans = new ArrayList<>();
		
		HashMap<String, List<String>> hm = new HashMap<>();
		
		for(int i = 0 ; i < tickets.length; i++) 
		{
				String from = tickets[i][0];
				String to = tickets[i][1];
				
				if(!(hm.containsKey(from))){
					
					List<String> li = new ArrayList<>();
					li.add(to);
					hm.put(from, li);
				}
				
				else {
					hm.get(from).add(to);
				}
		}
		
		
		for(Entry<String, List<String>> i :  hm.entrySet()) 
		{
			//Collections.sort(i.getValue());
			Collections.sort(i.getValue(), Collections.reverseOrder());
		}
		
		Stack<String> st = new Stack<>();
		st.push("JFK");
		while(st.size() > 0) 
		{
				
			if(hm.containsKey(st.peek())) 
			{
				String temp = st.peek();
				st.add(hm.get(temp).get(hm.get(temp).size() -1));
				hm.get(temp).remove(hm.get(temp).size() -1);
				if(hm.get(temp).size() == 0)
				{
					hm.remove(temp);
				}
			}
			
			else
			{
				ans.add(st.pop());
			}
		
		}
		
		
		
		Collections.reverse(ans);
		
		return ans;
		
	}
	
	
	

}
