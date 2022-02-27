class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j]==false)
                    count+=1;
                    islandCount(grid,i,j,visited);
            }
        }
        
            
        return count;
    }
    
    private void islandCount(char[][] grid, int row, int col,boolean[][] visited){
        
        if(row<0 || row>=grid.length || col < 0 || col >= grid[0].length || visited[row][col] == true || grid[row][col] == '0')          {
            return ;
        }
        
        visited[row][col] = true;
        islandCount(grid,row-1,col,visited);
        islandCount(grid,row+1,col,visited);
        islandCount(grid,row,col-1,visited);
        islandCount(grid,row,col+1,visited);
        
    }
}