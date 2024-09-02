package leetCode;

public class FindTheStudentThatWillReplaceTheChalk {

	public static void main(String[] args) {
	
		int[] chalk = {3,4,1,2};
		int k = 25;
//		
//		int[] chalk = {5,1,5};
//		int k = 22;
		System.out.println(chalkReplacer(chalk, k));
	
	
	}
	
	
	 public static int chalkReplacer(int[] chalk, int k) {
	        
	        long sum = 0 ;
	        for(int i : chalk){
	            sum+= i;
	        }

	        long rem = k % (long)sum;
	        int j = 0;
	        while(rem != 0){
	            if(rem >= chalk[j]){
	                rem = rem - chalk[j];
	                j++;
	            }
	            else{
	                break;
	            }

	        }

	        return j;

	    }

}
