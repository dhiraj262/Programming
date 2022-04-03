class Solution {
    public void nextPermutation(int[] nums) {
        int k = nums.length - 2;
        
        while(k >=0 && nums[k] >= nums[k+1]){
            k--;
        }
        
        if(k >=0){
            for(int i = nums.length-1;i > k;i--){
                if(nums[i] > nums[k]){
                    swap(nums,i,k);
                    break;
                }
            }
        }
        
        reverse(nums,k+1);
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}