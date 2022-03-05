class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length <=1) return 0;
        
        int sell = 0;
        int buy = -prices[0];
        int coolDown = 0;
        for(int i=1;i<prices.length;i++){
            
            int prevSell = sell;
            sell = buy + prices[i];
            buy = Math.max(buy , coolDown - prices[i]);
            coolDown = Math.max(coolDown , prevSell);
        }
        
        return Math.max(coolDown, sell);
    }
}