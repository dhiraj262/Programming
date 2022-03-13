class Solution {
    private int[] clone;
    private int[] arr;
    
    Random random = new Random();
    private int range(int l,int r){
        return random.nextInt(r-l) + l;
    }
    
    private void swap(int x, int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public Solution(int[] nums) {
        arr = nums;
        clone = nums.clone();
    }
    
    public int[] reset() {
        arr = clone;
        clone = clone.clone();
        return clone;
    }
    
    public int[] shuffle() {
         for (int i = 0; i < arr.length; i++) {
            swap(i, range(i, arr.length));
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */