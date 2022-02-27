class Solution {
    public int rob(int[] nums) {
        // Using include and exclude pattern
        
        int include = 0, exclude = 0;
        
        for(int i=0;i<nums.length;i++){
            int nInc = exclude + nums[i];
            int nexc = Math.max(include , exclude);
            
            include  = nInc;
            exclude = nexc;
            
        }
        
        return Math.max(include,exclude);
    }
}