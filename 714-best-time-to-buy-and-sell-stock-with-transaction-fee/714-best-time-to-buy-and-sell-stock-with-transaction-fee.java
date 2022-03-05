class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        if(prices.length <=1) return 0;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
           
            sell = Math.max(sell, buy + prices[i] - fee); // if bought before then sell it with fee
            
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}