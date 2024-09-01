package leetCode;

import java.util.Arrays;

public class UnionFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = {{3,4},{1,2},{2,4},{3,5},{2,5}};
		
		int[] array = new int[arr.length + 1];
		int[] rank = new int[arr.length + 1];
		
		Arrays.fill(array, -1);
		Arrays.fill(rank, 1);
		
		for(int i = 0 ; i < arr.length; i++){
			int a = arr[i][0];
			int b = arr[i][1];
			
			if(!areConnected(a,b,array)) {
				connect(a,b,array,rank);
			}
			else {
				System.out.println(a + ", " + b);
			}
		}
		
	}
	


	static boolean areConnected(int a, int b, int[] array) {
		
		if(getParent(a, array) == getParent(b, array)) 
		{
			return true;
			
		}
		
		return false;
		
	}
	
	
	 static int  getParent(int a, int[] array) {
				
		int i = a;
		while(array[i] != -1) {
				
			i = array[i]; 
		}
		return i;
	 }
	
	 static void connect(int a, int b, int[] array, int[] rank) {
		 
		int parent_a = getParent(a ,array);
		int parent_b = getParent(b ,array);
		
		if(rank[parent_a] < rank[parent_b]) {
			array[parent_a] =	 parent_b;
			rank[parent_b]  += rank[parent_a];
		}
		else {
			array[parent_b] = parent_a;
			rank[parent_a]  += rank[parent_b];
		}
		 
		 
	 }
	 
	 
	
	
}
