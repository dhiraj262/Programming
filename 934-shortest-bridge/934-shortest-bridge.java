class Solution {
    
    class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static  int[][] dirs= {{-1,0},{0,1},{1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
     Queue<Pair> queue= new LinkedList<>();
        boolean flag= false;
        int n= grid.length;
        int m = grid[0].length;
        
        for(int i= 0; i< n; i++)
        {
            for(int j= 0; j< m; j++)
            {
                if(grid[i][j] == 1)//island cell
                {   
                    flag= true;
                    dfs(grid, i, j, queue);//island connected add in the queue
                    
                    break;
                }
            }
            if(flag == true)break;
        }
        
        return nearestIsland(grid, queue);
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<Pair> q)
    {//add the sub-land of island into the queue
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0)
            return;
        
        grid[i][j]= -1;
        q.offer(new Pair(i, j));
        
        dfs(grid, i-1, j, q);
        dfs(grid, i, j+1, q);
        dfs(grid, i+1, j, q); 
        dfs(grid, i, j-1, q);
        
        return;
    }
    
    private int nearestIsland(int[][] grid, Queue<Pair> queue)
    {//BFS finds the shortest path length between the two points
       
        int steps= 0; 
        while(!queue.isEmpty())
        {
            int size= queue.size();
            while(size-- > 0){
                Pair cell= queue.poll();
                for(int []d: dirs)
                {
                   
                    int row= cell.x+ d[0];
                    int col= cell.y+ d[1];
                    if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == -1)
                        continue; 
                    
                    if(grid[row][col] == 1)
                        return steps;
                    
                    else
                    {
                        grid[row][col]= -1; 
                        queue.offer(new Pair(row, col));
                    }
                }
            }
            steps+= 1;
        }
        return -1;
    }
}