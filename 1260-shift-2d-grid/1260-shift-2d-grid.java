class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int m = grid.length, n = grid[0].length;

        for (int r = 0; r < m; r++)//All rows as empty lists
            res.add(new ArrayList());
        
        k %= (m * n);
        
        int d = m * n;
        int start = d - k;// element at (start) will be at 0,0 in new grid
        int c = 0;
        for (int i = start; i < start + d; i++) {
            
            int row = (i / n) % m, col = i % n;// calculating row and cell for new grid
            
            res.get(c / n).add(grid[row][col]);// adding new element in new row
            c++;
        }
        return res;// returning result list
        
    }
}