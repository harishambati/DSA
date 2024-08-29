package leetCode;

import java.util.Arrays;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] points = { {3,3},{5,-1},{-2,4}} ;
		 
		for(int[] i :KClosestPointsToOrigin( points,2) ) {
			System.out.println(i.toString());
		}
		
	}
	
	
	static int[][] KClosestPointsToOrigin(int[][] points , int  k){
		
		Arrays.sort(points, (a1, a2)-> Integer.compare(a1[0] * a1[0] + a1[1] * a1[1] , a2[0] * a2[0]  + a2[1] * a2[1] ));
		int[][] ans = new int[k][2];
		for(int i = 0; i < k ; i++) 
		{
			ans[i] = points[i];
			
		}
		
		
		return ans;
	}
	
}
