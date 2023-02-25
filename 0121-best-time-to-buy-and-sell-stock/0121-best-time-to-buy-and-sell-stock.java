class Solution {
    public int maxProfit(int[] prices) {
        int minTillNow = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minTillNow = Math.min(minTillNow, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minTillNow);
            
        }
        return maxProfit;
    }
}