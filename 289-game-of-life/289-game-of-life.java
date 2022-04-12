class Solution {
    private int dead = 2;
    private int live = 3;
    
    public void gameOfLife(int[][] board) {
       
        int m = board.length;
        int n = board[0].length;
        
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int neighbour = countLive(i,j,board);
                if (board[i][j] == 0 && neighbour == 3)
                    board[i][j] = live;
                else if (board[i][j] == 1){
                    if (neighbour == 2 || neighbour ==3)
                        continue;
                    if (neighbour < 2 || neighbour > 3)
                        board[i][j] = dead;
                }
            }
        }
        
          for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                 if (board[i][j] == dead)
                     board[i][j] = 0;
                 if (board[i][j] == live)
                     board[i][j] = 1;
                }
            }
        
    }
    
    private int countLive(int i, int j,int[][] board){
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for (int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if (x>=0 && y>=0 && x < board.length && y<board[0].length ){
                
                if (board[x][y] == 1 || board[x][y] == dead)
                    count ++;
            }
        }
        
        return count;
    }
    
}
 // we only flip the 1 to dead and 0 to live
        // so when we find a dead around, it must be a previous 1
        // then we can count the 1s without being affected