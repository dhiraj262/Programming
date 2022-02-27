class Solution {
    public int deleteAndEarn(int[] nums) {
        //same as house robber but here the numbers would be the count of intereger in nums.
        
        int i = 0;
        int c =0;
        
        int[] numsArr = new int[10001];
        for(int x:nums) numsArr[x]+=1;
        
        for(int j=0;j<=10000;j++){
           int nc = Math.max(i,c);
            i = c + numsArr[j]*j;
            c=nc;
        }
        
        return Math.max(i,c);
    }
}