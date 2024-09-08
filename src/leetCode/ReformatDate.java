package leetCode;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "6th Jun 1933";
		System.out.println(helper(a));
	}
	
	static String helper(String date) {
		
		Map<String, String> map = new HashMap<>();
		map.put("Jan", "01");
		map.put( "Feb", "02");
		map.put("Mar", "03");
		map.put("Apr", "04");
		map.put( "May", "05");
		map.put( "Jun" ,"06");
		map.put( "Jul", "07");
		map.put( "Aug" , "08");
		map.put("Sep", "09");
		map.put("Oct" , "10");
		map.put( "Nov" , "11");
		map.put( "Dec", "12");
		
	
		
		String f_date = "";
		int first_space = date.indexOf(' ');
		int second_space = date.lastIndexOf(' ');
		if(first_space - 2 < 2){
			f_date = "0";
		}
		 f_date = f_date + date.substring(0, first_space - 2);
		String f_month = date.substring(first_space + 1, second_space);
		String f_year = date.substring(second_space = 1);
		
		String ans = f_year +"-"+map.get(f_month) + "-" + f_date;
		return ans;
	}
	

}
