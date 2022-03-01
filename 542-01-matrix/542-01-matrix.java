class Solution {
    
    private static class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] dir4 = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i ,j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair cell = q.poll();
            
            for(int i=0;i<dir4.length;i++){
                int nr = cell.x + dir4[i][0];
                int nc = cell.y + dir4[i][1];
                
                if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length){
                    if(mat[nr][nc] == -1){
                        mat[nr][nc] = mat[cell.x][cell.y] + 1;
                        q.offer(new Pair(nr,nc));
                    }
                     
                }
            }
        }
        return mat;
    }
}