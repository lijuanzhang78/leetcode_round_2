package DP;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min_price = prices[0];
        int max_profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > min_price) max_profit = Math.max(max_profit, prices[i]-min_price);
            min_price = Math.min(min_price, prices[i]);
        }
        return max_profit;
    }
}
