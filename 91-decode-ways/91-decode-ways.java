class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
            }
        char[] charArr = s.toCharArray();
        int[] dp = new int[charArr.length];
        if(charArr[0] == '0') dp[0] = 0;
        else dp[0] =1;
        
        for (int i = 1; i < charArr.length; i++) {
            
            if (charArr[i] >= '1' && charArr[i] <= '9') {
                dp[i] = dp[i - 1];
            }
            if ((charArr[i-1] == '1' && charArr[i] >= '0' && charArr[i] <= '9') ||
                    (charArr[i-1] == '2' && charArr[i] >= '0' && charArr[i] <= '6')) { // 10 -19 || 20-26
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[charArr.length - 1];
        }
}