class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int l = n - 1; l >= 0; l--) {
            dp[l][l] = 1;
            for (int r = l + 1; r < n; r++) {
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = dp[l + 1][r - 1] + 2;
                }
                else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}