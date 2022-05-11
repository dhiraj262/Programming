class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        if(nums == null || nums.length < 1){
            return -1;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int currSum = 0,c=0,remainder=0;
        for(int i=0;i<nums.length;i++){
            currSum +=nums[i];
            remainder = currSum%k;
            
            if(remainder < 0){
                remainder +=k;
            }
            
            if(map.containsKey(remainder)){
                c+=map.get(remainder);
                map.put(remainder,map.getOrDefault(remainder,0)+1);
                
            } else {
                map.put(remainder,1);
            }
        }
        return c;
    }
}