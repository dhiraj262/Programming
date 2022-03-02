class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        int maxValue = maxProd;
        for(int i=1;i<nums.length;i++){
            
            int pmax = Math.max(maxProd * nums[i], Math.max(nums[i], minProd*nums[i]));
            int pmin = Math.min(maxProd * nums[i], Math.min(nums[i], minProd*nums[i]));
            maxValue = Math.max(pmax, maxValue);
            
            maxProd = pmax;
            minProd = pmin;
        }
        
        return maxValue;
    }
}