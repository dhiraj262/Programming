class Solution {
    public boolean exist(char[][] board, String word) {
        // Start dfs where first character of word found in board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(board,word,0,i,j))
                    return true;
            }
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board, String word, int pos,int row,int col){
        
        if(word.length() <=pos) return true;
        // Boundary condition check
        if(row<0 || col<0 || row>=board.length || col >=board[0].length || board[row][col] == '*' || board[row][col]!=word.charAt(pos)) 
            return false;
        //store the current character
        char ch = board[row][col];
        board[row][col] = '*';
        
        if(dfs(board,word,pos+1,row+1,col) || dfs(board,word,pos+1,row-1,col) || dfs(board,word,pos+1,row,col+1) || dfs(board,word,pos+1,row,col-1)) 
            return true;
        
        //change back to the original caracter 
        board[row][col] = ch;
        return false;
    }
}