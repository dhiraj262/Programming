class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n+1];
        if(n==1) return 1;
        for(int i=0;i<trust.length;i++){
            trustCount[trust[i][0]] --; // the person trusting the judge
            trustCount[trust[i][1]] ++; // the person being trusted by other
        }
        
        for(int i=0;i<trustCount.length;i++){
            
            if(trustCount[i] == n-1) return i;
        }
        
        return -1;
    }
}