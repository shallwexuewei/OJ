public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) {
            return 0;
        }
        if(len == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int preBuy = Integer.MIN_VALUE;
        int prevSell = 0;
        for(int price:prices) {
            preBuy = buy;
            buy = Math.max(prevSell-price, preBuy);
            prevSell = sell;
            sell = Math.max(prevSell, preBuy + price);
        }
        
        return sell;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2,4]
Output:
2
Expected:
3

Submission Result: Wrong Answer More Details 

Input:
[1,2,3,0,2]
Output:
4
Expected:
3

*/
