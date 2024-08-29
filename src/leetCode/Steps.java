package leetCode;


class Steps {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
	}

	
    public static int numSteps(String s) {

     long decimal = 0;

        for(int i = 0; i  < s.length(); i++){
            if(s.charAt(i)== '1'){
              decimal =  (long)1 << (s.length() -1 - i) | decimal;

            }
        }
    
    int steps  = steps(decimal);

    return steps;
    }


    static int steps(long decimal)
    {
        
 
        if(decimal == 1){return 0;}
       
            int ans = 0;
        if(decimal % 2 == 0){
            ans = steps(decimal / 2);
        }

        else{
            ans = steps(decimal + 1);
        }

        return ans + 1;

    }

}