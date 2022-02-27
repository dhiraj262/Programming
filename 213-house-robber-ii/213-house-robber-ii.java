class Solution {
    public int rob(int[] nums) {
        
        
        if(nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0],nums[1]);
        
        return Math.max(rob2(nums,0,nums.length-2),rob2(nums,1,nums.length-1));
    }
    
    private int rob2(int[] nums, int start,int end){
        
        int inc = 0;
        int exc = 0;
        for(int i=start;i<=end;i++){
            int ninc = exc + nums[i];
            int nexc = Math.max(inc , exc);
            
            inc = ninc;
            exc = nexc;
            
        }
        
        return Math.max(inc,exc);
    }
}