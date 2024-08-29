package leetCode;

class StudentAttendance2 {
	
	public static void main(String[] args) {
		int[] cardPoints = {1,2,3,4,5,6,1};
		System.out.println(maxScore(cardPoints, 3));;
	}
	
    public static int maxScore(int[] cardPoints, int k) {
        int max_score = 0;
        for(int i : cardPoints){
            max_score = max_score + i;
        }

        int sum = 0 ;
        for(int i = 0 ; i < k ; i++){
            sum += cardPoints[i];
        }
        int i = 0;
        int j  = k;
        int min = sum;
        while( j < cardPoints.length)
        {    
            sum = sum - cardPoints[i] +  cardPoints[j];
            min = Math.min(min, sum);
            i++;
            j++;
        }

        return max_score - min;
    }
}