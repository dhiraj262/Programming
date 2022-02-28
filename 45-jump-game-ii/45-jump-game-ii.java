class Solution {
    public int jump(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[nums.length-1] = 0;
        
        for(int i=nums.length-2;i>=0;i--){
            
            int noOfSteps = nums[i];
            
            // iterating till maximum step
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=noOfSteps;j++){
                
                if(i+j >=nums.length) break;
                
                if(dp[i+j] < min){
                    min = dp[i+j];
                }
            }
            if(min!=Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }
        
        return dp[0];
    }
}