class Solution {
    public int maxProfit(int[] prices) {
        int[] maxRight = maxGreaterElement(prices);
        int maxProfit = 0;
        for(int i = 0;i < prices.length; i++)
        {
            if(maxRight[i] !=  -1)
            {
                int profit = maxRight[i] - prices[i];
                maxProfit = Math.max(profit,maxProfit);

            }
        }
        return maxProfit;
    }
    public int[] maxGreaterElement(int[] prices)
    {
        int[] maxRight = new int[prices.length];
        int maxSoFar = -1;
        for(int i = prices.length - 1;i >= 0;i--)
        {
            if(prices[i] > maxSoFar)
            {
                maxRight[i] = -1;
            }
            else
            {
                maxRight[i] = maxSoFar;
            }
            maxSoFar = Math.max(maxSoFar,prices[i]);
        }
        return maxRight;
    }

}
