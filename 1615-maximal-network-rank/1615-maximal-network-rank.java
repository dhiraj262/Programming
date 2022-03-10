class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] roadConnected = new int[n+1];
        
        boolean[][] roadExists = new boolean[n][n];
        
        for(int i=0;i<roads.length ;i++){
            // count of connected cities.
            roadConnected[roads[i][0]]++;   
            roadConnected[roads[i][1]]++;
            
            roadExists[roads[i][0]][roads[i][1]] =roadExists[roads[i][1]][roads[i][0]]= true;
        }
        
        int max=0;
        for(int i=0;i<n-1;i++){
            for(int j= i+1; j<n ;j++){
                //total number of road connected to both city
                int rank = roadConnected[i] + roadConnected[j];
                
                if(roadExists[i][j] == true) rank--;
                
                max = Math.max(max,rank);
            }
        }
        return max;
    }
}