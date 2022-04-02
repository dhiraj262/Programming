class Solution {
    public int singleNumber(int[] nums) {
        
        // using XOR approach
        
        int xor = nums[0];
        // every element is twice so their xor would be 0
        // 0 xor any number is that number
        for(int i=1;i<nums.length;i++){
            
            xor = xor ^ nums[i];
        }
        
        return xor;
    }
}