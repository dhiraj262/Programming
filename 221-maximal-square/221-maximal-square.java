class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m+1];
        int maxLen = 0, prev=0;  // prev is diagonally upper
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                int curr =dp[j];
                
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1],prev),dp[j])+1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j]=0;
                }
                prev = curr;
            }
        }
        
        return maxLen * maxLen;
    }
}