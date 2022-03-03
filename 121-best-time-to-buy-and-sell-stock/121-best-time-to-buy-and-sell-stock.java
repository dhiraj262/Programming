class Solution {
    public int maxProfit(int[] prices) {
        
        int minimum = prices[0], maxProfit = 0, profit=0;;
        
        for(int i=0;i< prices.length;i++){
            
            if(prices[i] < minimum){
                minimum = prices[i];
            }
            
            profit = prices[i] - minimum;
            
            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
}