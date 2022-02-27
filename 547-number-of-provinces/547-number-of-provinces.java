class Solution {
    public int findCircleNum(int[][] isConnected) {
     int count = 0;
        
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1){
                    count+=1;
                    provinceCount(isConnected,i,j);
                }
            }
        }
        
        return count;
    }
    
    private void provinceCount(int[][] grid, int row, int col){
        
        grid[row][col] = 0;
        
        for(int i=0;i<grid[row].length;i++){
            if(grid[col][i] ==1)
            provinceCount(grid, col,i);
        }
       
        
    }
}