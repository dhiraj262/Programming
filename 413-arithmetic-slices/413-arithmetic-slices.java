class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int d = 0, count=0,ans=0;
        if(nums.length<3) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] - nums[i-1] == d){
                count++;
                
                if(count>=2){
                    ans+=count-1;
                }
            } else {
                d= nums[i]-nums[i-1];
                count=1;
            }
        }
        return ans;
    }
}