class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Integer.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[amount];
    }
}