class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1, suffix = 1;
        
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        
        for (int i = 0;i<nums.length;i++) {
            
            res[i]*=prefix;
            prefix*=nums[i];
            
            res[nums.length-i-1]*=suffix;
            suffix*=nums[nums.length-i-1];
        }
        return res;
    }
}