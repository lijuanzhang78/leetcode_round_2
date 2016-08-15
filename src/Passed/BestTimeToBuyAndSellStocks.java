package Passed;

public class BestTimeToBuyAndSellStocks {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxPro = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        
        return maxPro;
    }
}
