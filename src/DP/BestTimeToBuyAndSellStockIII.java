package DP;

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int leftmin = prices[0];
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        for(int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i-1], prices[i] - leftmin);
            leftmin = Math.min(leftmin, prices[i]);
        }
        int rightmax = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], rightmax-prices[i]);
            rightmax = Math.max(rightmax, prices[i]);
        }
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            res = Math.max(left[i]+right[i], res);
        }
        return res;
    }
}
