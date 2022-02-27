class Solution {
    boolean check = false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int c =0 ;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    check = true;
                    dfs(grid1,grid2,i,j);
                    if(check)c++;
                }
            }
        }
        return c;
    }
    
    private void dfs(int[][] grid1, int[][] grid2,int row, int col){
        
       if (row < 0 || row >= grid2.length || col< 0 || col >= grid2[0].length || grid2[row][col] == 0)
           return;
        grid2[row][col] = 0;
        
        if (grid1[row][col] == 0) check =false;
        
        dfs(grid1, grid2, row+1, col);
        dfs(grid1, grid2, row-1, col);
        dfs(grid1, grid2, row, col+1);
        dfs(grid1, grid2, row, col-1);
       
    }
}