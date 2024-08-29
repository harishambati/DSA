package leetCode;
import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] coins = {186,419,83,408};
		int x = coinChange(coins, 6249);
	

	}
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;


    
        intCoinChangeHelp(coins, amount, dp);
          
             return dp[amount];
    
    }


    public static int intCoinChangeHelp(int[] coins, int amount, int[] dp)
    {
           if(amount == 0){
                return 0;
           } 

           if(amount < 0){
            return Integer.MAX_VALUE;
           }
           

            int coins_reqd = Integer.MAX_VALUE;

            for(int i = 0; i < coins.length; i++)
            {   

                if( amount - coins[i] >= 0){
                    int x = intCoinChangeHelp(coins, amount - coins[i], dp);
               
                     coins_reqd = Math.min(x + 1 , coins_reqd);
                }
                              
            }

            dp[amount] = coins_reqd;

            return coins_reqd;
    }

}