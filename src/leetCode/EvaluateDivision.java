package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		List<String> first = new ArrayList<>();
		first.add("a");
		first.add("b");
		
		List<String> scnd = new ArrayList<>();
		scnd.add("b");
		scnd.add("c");
		equations.add(first);
		equations.add(scnd);
		double[] values = {2.0,3.0};
		
		List<List<String>> queries = new ArrayList<>();
		List<String> t = new ArrayList<>();
		t.add("a");
		t.add("c");
		
		List<String> f = new ArrayList<>();
		f.add("b");
		f.add("a");
		
		List<String> fi = new ArrayList<>();
		fi.add("a");
		fi.add("e");
		
		List<String> s = new ArrayList<>();
		s.add("a");
		s.add("a");
		

		List<String> se = new ArrayList<>();
		se.add("x");
		se.add("x");
		
		queries.add(t);
		queries.add(f);
		queries.add(fi);
		queries.add(s);
		queries.add(se);
		
		calcEquation(equations, values, queries);
		
		
	}
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		
		Map<String, List<Pair3>> map = new HashMap<>();
		
		for(int i = 0 ; i < equations.size(); i++) {
			String s1 = equations.get(i).get(0);
			String s2 = equations.get(i).get(1);
			
			Pair3 p1 = new Pair3(s2,values[i]);
			if(map.containsKey(s1)) {
				map.get(s1).add(p1);
			}
			else {
				List<Pair3> ls = new ArrayList<>();
				ls.add(p1);
				map.put(s1, ls);
			}
			
			Pair3 p2 = new Pair3(s1, 1/(double)values[i]);
			if(map.containsKey(s2)) {
				map.get(s2).add(p2);
			}
			else {
				List<Pair3> ls = new ArrayList<>();
				ls.add(p2);
				map.put(s2, ls);
			}
			
		}
		
		double[] ans = new double[queries.size()];
		
		
		for(int i = 0 ; i < queries.size(); i++) {
			String src = queries.get(i).get(0);
			String dst = queries.get(i).get(1);
			
			double ans_ = bfs(src, dst, map);
			ans[i] = ans_;
 			System.out.println(ans_);
			
		}
		
		return ans;
	      
    }
	
	
	static double  bfs(String src, String dst, Map<String, List<Pair3>> map ) {
		
		
		boolean src_boo = map.containsKey(src);
		boolean dst_boo = map.containsKey(dst);
		if(!src_boo || !dst_boo) {
			return (double)-1;
		}
		if(src == dst) {
			return 1;
		}
		
		Set<String> set = new HashSet<>();
		
		Queue<Pair3> q = new LinkedList<>();	
		
		q.add(new Pair3(src,1));
		
		while(q.size() > 0) {
			
			Pair3 temp = q.remove();
			set.add(temp.node);
			double cost = temp.cost;
			String node = temp.node;
			
			List<Pair3> ngbs = map.get(node);
			
			for(Pair3 pa : ngbs) {
				
				if(set.contains(pa.node)) {
					continue;
				}
				
				if(pa.node == dst) {
					return cost * pa.cost;
				}
				
				else {
					q.add(new Pair3(pa.node, cost * pa.cost));
				}
			}
			
		}
		
		
		return (double)-1;
	}

}

class Pair3{
	String node;
	double cost;
	Pair3(String node, double cost){
		this.cost = cost;
		this.node = node;
	}
}
