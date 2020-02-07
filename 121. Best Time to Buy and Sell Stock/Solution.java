/**
 * Runtime: 1 ms, faster than 77.52% of Java online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 42.7 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
}