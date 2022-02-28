class Solution {
    //Using BFS Approach at each level increment count;
    class Cell{
        int x;
        int y;
        
        Cell(int x,int y){
            this.x = x;
            this.y =y;
        }
    }
    
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    public int maxDistance(int[][] grid) {
        
        Queue<Cell> queue = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j] == 1){
                    queue.add(new Cell(i,j));
                } 
            }
        }
        
        int res = 0;
        while(!queue.isEmpty()){
            Cell currCell = queue.poll();
            
            for(int i=0;i<dirs.length;i++){
                int row = currCell.x + dirs[i][0];
                int col = currCell.y + dirs[i][1];
                
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==0){
                    queue.add(new Cell(row,col));
                    grid[row][col] = grid[currCell.x][currCell.y] +1;
                    res = Math.max(res, grid[row][col]);
                }
            }
            
        }
        return res-1;
    }
}