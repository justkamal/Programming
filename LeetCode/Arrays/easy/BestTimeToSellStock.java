package Arrays.easy;


/**
 * Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Companies: amazon | bloomberg | facebook | microsoft | uber
 * */
public class BestTimeToSellStock {

    public int maxProfit(int[] prices){
        int lowest = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; ++i){
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
            if (prices[i] < lowest)
                lowest = prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        BestTimeToSellStock mainObj = new BestTimeToSellStock();
        System.out.println(mainObj.maxProfit(arr));
    }
}
