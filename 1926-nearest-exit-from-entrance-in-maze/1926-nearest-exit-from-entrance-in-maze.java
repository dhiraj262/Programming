class Solution {
    
    public static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; 
    public int nearestExit(char[][] maze, int[] entrance) {
        
        //Using BFS
        Queue<int[]> queue = new LinkedList<>();
        int exitDist  =1;
        
        int n = maze.length, m = maze[0].length;
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                int[] cell = queue.poll();

                 for (int d = 0; d < dirs.length; d++) {
                    int row = cell[0] + dirs[d][0];
                    int col = cell[1] + dirs[d][1];

                    if (row >= 0 && col >= 0 && row < n && col < m && maze[row][col] == '.') {
                        if(row==0 || row== n-1 || col==0 ||col==m-1) return exitDist;
                        
                        maze[row][col] = '+';
                        queue.add(new int[]{row, col});
                    }
                }
             }
            exitDist++;
         }
        return -1;
    }
}