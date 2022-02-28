class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result= new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            dfs(heights, pacific, 0, i, 0);
            dfs(heights, atlantic, 0, i, n-1);
        }
        
        for(int i = 0; i < n; i++){
            dfs(heights, pacific, 0, 0, i);
            dfs(heights, atlantic, 0, m-1, i);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                    
                result.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    // h is the parent height, if the next hight is smaller than h, that means water could not
	// flow into ocean. Remember we are going back up from the borders.
    private void dfs(int[][] heights, boolean[][] v, int h, int x, int y){
        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || v[x][y]==true || heights[x][y] < h)
            return;
        v[x][y] = true;
        dfs(heights, v, heights[x][y], x, y+1);
        dfs(heights, v, heights[x][y], x+1, y);
        dfs(heights, v, heights[x][y], x, y-1);
        dfs(heights, v, heights[x][y], x-1, y);
    }
}