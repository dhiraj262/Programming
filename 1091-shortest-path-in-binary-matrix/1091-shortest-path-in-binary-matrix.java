class Solution {
    
     private static class Pair{
        int x;
        int y;
         int s;
        
        Pair(int x,int y,int s){
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
    private static int[][] dir8 = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
     
        if (grid[0][0] == 1)
            return -1;
        
        int n = grid.length;
    
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1));
        
        while (!queue.isEmpty()) {

            Pair cell = queue.poll();
        
            int ans = cell.s;
            
            if (cell.x == (n - 1) && cell.y == (n - 1))
                return ans;
            
            for (int[] dir: dir8) {
                
                int dx = cell.x +dir[0];
                int dy = cell.y +dir[1];
                
                if ((0 <=  dx) 
                    && ( dx < n) 
                    && (0 <=  dy) 
                    && ( dy < n) 
                    && (grid[ dx][ dy] == 0)) {
                    
                    grid[dx][dy] = 1;
                    queue.add(new Pair(dx, dy, ans + 1));
                }
            }
        }

        return -1;
    }
}