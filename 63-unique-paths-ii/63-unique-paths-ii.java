class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        
        int[] dp = new int[n];  // using only 1-D array to store values
        dp[0] = 1;
        
        for (int[] row : obstacleGrid) {
            for (int col = 0; col< n; col++) {
                if (row[col] == 1)
                    dp[col] = 0;
                else if (col > 0)
                    dp[col] += dp[col - 1];
            }
        }
        return dp[n - 1];
    }
}