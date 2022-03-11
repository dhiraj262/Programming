class Solution {
    public int lengthOfLIS(int[] nums) {
        int last[] = new int[nums.length];
        int len=0;
        for(int num:nums){
            
            int start=0,end= len; // Binary search
            while(start != end){
                int mid =start + (end-start)/2;
                
                if(last[mid] < num) start = mid+1;
                else end = mid;
            }
            
            last[start] = num;
            if(start == len) len++;
        }
        return len;
    }
}