package leetCode;


class Hindex {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ciations = {1,3,1};
		
		System.out.println(hIndex(ciations));
	}

	
    public static int hIndex(int[] citations) {
        
        int max  = citations[0];

        for(int i : citations){
            if(i > max){
                max = i;
            }
        }

        int[] ans = new int[max + 1];

        for(int i = 0 ; i < citations.length; i++){

                int index = citations[i];

                ans[index] = ans[index] + 1;


        }


        for(int i = ans.length -2; i >= 0; i--){
            ans[i] = ans[i + 1] + ans[i];
        }

        for(int i = ans.length -1 ; i >= 0; i-- ){
            if(ans[i]>= i){
                return i;
            }
        }


        return 0;
    }
}
