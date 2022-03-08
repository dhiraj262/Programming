class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            
            int min = Math.min(Math.min(factor2,factor3),factor5);
            nums[i] = min;
            if(factor2 == min)
                factor2 = 2*nums[++i2];
            if(factor3 == min)
                factor3 = 3*nums[++i3];
            if(factor5 == min)
                factor5 = 5*nums[++i5];
        }
        return nums[n-1];
    }
}