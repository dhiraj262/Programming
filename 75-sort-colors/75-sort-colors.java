class Solution {
    public void sortColors(int[] nums) {
        
        int zeros=0, i = 0, j =nums.length-1;
        
        while(i <= j){
            if(nums[i] < 1){
                swap(nums,zeros++,i++);
                
            } else if(nums[i] == 1){
                i++;
            } else {
                swap(nums , i, j--);
            }
        }
    }
    
    private void swap (int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}