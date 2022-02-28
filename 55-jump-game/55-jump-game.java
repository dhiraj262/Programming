class Solution {
    public boolean canJump(int[] nums) {
        
        int lastReachable = nums.length -1;
        for(int i = nums.length-1; i>=0 ;i--){
            if(lastReachable <= i+nums[i]){
                lastReachable = i;
            }
        }
        
        if(lastReachable == 0) return true;
        else return false;
    }
}