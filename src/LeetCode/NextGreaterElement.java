package LeetCode;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//			   0 1 2 3 4	
		int[] array = {1,2,2,3,3,3,3,3};
		System.out.println(getNextGreaterElement(array,3));
	}
	
	
	static int getNextGreaterElement(int[] array, int target)
	{		
		int i = 0;
		int j = array.length -1;
		int index = -1;
		while(i <= j) {
			float temp = i + (j - i)/(float)2;
			int mid = (int) Math.ceil(temp);
			if(array[mid] == target) {
					index = mid;
					j = mid - 1;
			}
			
			else if(array[mid] > target) {
					index = mid;
					j = mid - 1;
			}
			
			else {
				i = mid + 1;
			}
			
		}
		
		
		return index;
	}
}
