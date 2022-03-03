class Solution {
    public int getMaxLen(int[] nums) {
        
        int maxProd = 0;

        int i=0;
        while(i < nums.length){
            
            int start = i;
            while(start < nums.length && nums[start] == 0) { // for zero case, avaoid zero
                start++;
            }
            
            int end = start;   // end starting from non-zero value
            int ns = -1,ne =-1;
            int nCount=0;
            while(end < nums.length && nums[end] !=0){
                
                if(nums[end]<0){
                    nCount+=1;
                    if(ns == -1) ns=end;
                    ne = end;
                }
                
                end+=1;
            }
            
            if(nCount %2 ==0){  // count of negative values in subarray is even 
              maxProd = Math.max(maxProd, end -start+1);   
            } else {
                if(ns != -1) {
                    maxProd =Math.max(maxProd , end -ns);
                }
                if(ne != -1) {
                    maxProd =Math.max(maxProd , ne -start+1);
                }
            }
            
            i = end+1;
            
        }
        return maxProd-1;
    }
}