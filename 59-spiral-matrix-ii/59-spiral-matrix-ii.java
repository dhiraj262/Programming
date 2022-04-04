class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        int num=1;
        
        for(int row = 0; row < (n+1)/2 ;row++){
            // L->R
            for(int i=row;i < n-row;i++){
                matrix[row][i] = num++;
            }
            // T->B
            for(int i=row+1;i < n-row;i++){
                matrix[i][n-row-1] = num++;
            }
            // R->L
            for(int i=row+1;i < n-row;i++){
                matrix[n-row-1][n - i -1] = num++;
            }
            // B->T
            for(int i=row+1;i < n-row -1;i++){
                matrix[n - i -1][row] = num++;
            }
        }
        return matrix;
    }
}