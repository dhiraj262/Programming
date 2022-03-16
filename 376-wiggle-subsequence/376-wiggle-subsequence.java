class Solution {
    public int wiggleMaxLength(int[] nums) {
        //Greedy - count all changes of direction (all peaks and valleys) 
        
        int n = nums.length;
        if(n <=1) return n;
        
        int prevDiff = nums[1]-nums[0];
        int len = prevDiff !=0 ? 2:1;
        for(int i=2;i<n;i++){
            int diff = nums[i] - nums[i-1];
            
            if((diff > 0 && prevDiff <=0 ) || (diff < 0 && prevDiff >=0)){
                len++;
                prevDiff = diff;
            }
        }
        return len;
    }
}