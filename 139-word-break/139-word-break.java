class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      
        boolean[] dp = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i + 1 && s.substring(i - word.length() + 1, i + 1).equals(word)) {
                    int index = i - word.length();
                    if (index < 0)  {
                        dp[i] =  true;
                    } else {
                        dp[i] = dp[index];
                    }
                    if(dp[i] == true) break;
                }
            }
        }
        
        return dp[s.length() - 1];
    }
}