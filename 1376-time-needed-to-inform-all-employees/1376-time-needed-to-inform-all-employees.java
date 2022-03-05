class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int[] times = new int[n];
        Arrays.fill(times,-1);
        
        int maxTime = informTime[headID];
        times[headID] = informTime[headID];
        for(int i=0;i<n;i++){
            if(i==headID) continue;
            
            maxTime = Math.max(maxTime, upperManTime(i,manager,informTime,times));
        }
        return maxTime;        
    }
    private int upperManTime(int id, int[] manager, int[] informTime, int[] times){
        
        if(times[id] != -1) return times[id];
        
        times[id] = informTime[id] + upperManTime(manager[id],manager,informTime,times);
        return times[id];
    }
    
}