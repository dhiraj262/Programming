class Solution {
    // using static DP
   static List<Integer> dp = new ArrayList<>();
    
    public int numSquares(int n) {
        
        if (dp.size() == 0) {
            dp.add(0);
        }
        
        while (dp.size() <= n) {
            int size = dp.size();
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= size; i++) {
                min = Math.min(min, dp.get(size - i * i) + 1);
            }
            dp.add(min);
        }
        return dp.get(n);  
    }
}