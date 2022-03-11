class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dpLen = new int[n];
        int[] dpCnt = new int[n];
        Arrays.fill(dpLen,1);
        Arrays.fill(dpCnt,1);
        int maxLen = 1; // atleast 1
        int total = 0;

        for(int i=0; i < n; i++){
         
          for(int j=0; j < i; j++){
            if(nums[i] > nums[j]){
              // Take the dpLen[j] subsequence length and increment by 1
              // and copy the dpCnt[j] to dpCnt[i] as the number of ways to reach j and i will be the same
              if(dpLen[i] < dpLen[j] + 1){
                dpLen[i] = dpLen[j] + 1;
                dpCnt[i] = dpCnt[j];
              } 
              // If there are more than one ways to reach dpLen[i] while forming the subsequence length
              // same as dpLen[j]+1, then we update the dpCnt[i] by adding it to the no. of ways we could reach j
              else if (dpLen[i] == dpLen[j] + 1) {
                dpCnt[i] += dpCnt[j];
              }
            }
          }
          // When more than one way we can reach the maxLen, then we add dpCnt[i] to the total ways
          if(maxLen == dpLen[i])
            total += dpCnt[i];
          // When dpLen[i] is bigger than maxLen, then we reset maxLen and total
          if(maxLen < dpLen[i]){
            maxLen = dpLen[i];
            total = dpCnt[i];
          }
        }
        return total;
    }
}