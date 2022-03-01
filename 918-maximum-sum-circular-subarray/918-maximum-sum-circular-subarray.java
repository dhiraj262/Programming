class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //Kadane using maximum and minimum
        
         int max=Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
         int sumMax =0,sumMin=0 ,sum=0;
        for(int i=0;i<nums.length;i++){
           sum+=nums[i];
            
           sumMax = Math.max(sumMax,0)+nums[i];
           max = Math.max(max,sumMax);
            
           sumMin = Math.min(sumMin,0)+nums[i];
           min = Math.min(min,sumMin);

        }
        //For all negative
        if(max < 0) return max;
        return Math.max(max, sum-min);
    }
}