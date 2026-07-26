class Solution {
    public int coinChange(int[] coins, int sum) {
        if(sum == 0) return 0;

        int[][] dp = new int[coins.length][sum+1];

        int ans = helper2(0, sum, coins, dp);

        return (ans!=Integer.MAX_VALUE) ? ans : -1;
    }

    //i -> 0 to n-1   sum -> sum to 0
    public static int helper2(int i , int sum, int[] coins, int[][] dp){
        if(i == coins.length){
            if(sum == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][sum] != 0) return dp[i][sum];

        int skip = helper2(i+1,sum, coins, dp);

        if(sum < coins[i]) return dp[i][sum] = skip;

        int take = helper2(i, sum - coins[i], coins, dp);

        int pick = (take == Integer.MAX_VALUE) ? take : take + 1;

        return dp[i][sum] = Math.min(skip,pick);
    }
}