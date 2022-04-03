class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // using 2 pointer approach in sorted array
        
        List<List<Integer>> sol = new ArrayList<>();
        int target = 0;
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            
            if( i == 0|| i > 0 && nums[i] !=nums[i-1]){
                
                int l = i+1;
                int r = nums.length-1;
               while(l<r){
                if(nums[i]+nums[l]+nums[r] > 0)
                    r--;
                else if(nums[i]+nums[l]+nums[r] < 0)
                    l++;
                else{
                    sol.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    while(nums[l]==nums[l-1] && l<r)
                        l++;
                 }                       
            }
            }
        }
        
        return sol;
        
    }
}