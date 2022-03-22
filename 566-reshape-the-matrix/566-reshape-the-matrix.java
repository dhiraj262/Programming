class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        if(r * c != mat.length * mat[0].length) return mat;
        int[][] newMat = new int[r][c];
        for(int i=0;i< r*c ;i++){
            newMat[i/c][i%c] = mat[i/mat[0].length][i%mat[0].length];
        }
        
        return newMat;
    }
}