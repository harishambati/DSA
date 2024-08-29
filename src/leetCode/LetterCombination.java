package leetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			HashMap<Integer, List<Character>> hm = new  HashMap<>();
			StringBuilder sb = new StringBuilder("");
			List<Character> a = new ArrayList<>();
			a.add('a');
			a.add('b');
			a.add('c');
			List<Character> b = new ArrayList<>();
			b.add('d');
			b.add('e');
			b.add('f');
			hm.put(2,a);
			hm.put(3, b);
			List<Character> c = new ArrayList<>();
			c.add('g');
			c.add('h');
			c.add('i');
			
		    hm.put(4, c);
		    List<Character> d = new ArrayList<>();
			c.add('j');
			c.add('k');
			c.add('l');
			// hm.put(5, d);
			List<List<Character>> temp2 = new ArrayList<>();
			List<Character> temp3 = new ArrayList<>();
			phoneNummber(temp3, temp2, hm, sb);
			
			
			
			
	}

	
	
	
	public static void phoneNummber(List<Character> arr,  List<List<Character>> ans, HashMap<Integer, List<Character>> hm, StringBuilder sb) 
	{
		
		if(arr.size() == hm.size()) {
			List<Character> temp = new ArrayList<>();
//			temp.add(arr.get(0));
//			temp.add(arr.get(1));
//		    temp.add(arr.get(2));
		  //  temp.add(arr.get(3));
			System.out.println(sb.toString());
			ans.add(temp);
			return;
		}
		
		
			if(arr.size() == 0 && hm.size() >= 1) {
				for(int i1 = 0; i1 < hm.get(2).size(); i1++) {
//					arr.add(hm.get(2).get(i1));
//					phoneNummber(arr,  ans, hm); 
//					arr.remove(arr.size() -1);
					sb.append(hm.get(2).get(i1));
					phoneNummber(arr,  ans, hm, sb); 
					sb.deleteCharAt(sb.capacity() -1);
					
				}
			}
			
			if(arr.size() == 1 &&  hm.size() >= 2) {
				for(int i1 = 0; i1 < hm.get(3).size(); i1++) {
//					arr.add(hm.get(3).get(i1));
//					phoneNummber(arr , ans, hm); 
//					arr.remove(arr.size() -1);
					
					sb.append(hm.get(4).get(i1));
					phoneNummber(arr,  ans, hm, sb); 
					sb.deleteCharAt(sb.capacity() -1);
					
				}
			}
			
			if(arr.size() == 2 &&  hm.size() >= 3) {
				for(int i1 = 0; i1 < hm.get(4).size(); i1++) {
//					arr.add(hm.get(4).get(i1));
//					phoneNummber(arr , ans, hm); 
//					arr.remove(arr.size() -1);
					sb.append(hm.get(4).get(i1));
					phoneNummber(arr,  ans, hm, sb); 
					sb.deleteCharAt(sb.capacity() -1);
					
				}
			}
			
			if(arr.size() == 3 &&  hm.size() >= 4) {
				for(int i1 = 0; i1 < hm.get(5).size(); i1++) {
//					arr.add(hm.get(5).get(i1));
//					phoneNummber(arr , ans, hm); 
//					arr.remove(arr.size() -1);
					sb.append(hm.get(5).get(i1));
					phoneNummber(arr,  ans, hm, sb); 
					sb.deleteCharAt(sb.capacity() -1);
					
				}
			}
			
		
		}
	
	
	
	
	
	
	
	
	
	
}
