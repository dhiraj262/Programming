class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O')
                dfs(board,i, 0);
            if(board[i][m-1] == 'O')
                dfs(board,i, m-1);
        }
        
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O')
                dfs(board,0, j );
            if(board[n-1][j] == 'O')
                dfs(board,n-1, j );
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    
    private static void dfs(char[][] board,int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        if(board[row][col] != 'O')
            return;
        board[row][col] = '*';
        dfs(board,row+1, col );
        dfs(board,row-1, col);
        dfs(board,row, col+1);
        dfs(board,row, col-1);
    }
}