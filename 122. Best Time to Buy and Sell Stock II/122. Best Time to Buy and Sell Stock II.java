/**
 * Runtime: 1 ms, faster than 93.33% of Java online submissions for Best Time to Buy and Sell Stock II.
 * Memory Usage: 39.4 MB, less than 17.14% of Java online submissions for Best Time to Buy and Sell Stock II.
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}