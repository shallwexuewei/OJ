public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 1) {
            return 0;
        }
        
        int valley = 0;
        int profit = 0;
        valley = prices[0];
        for(int i = 1; i < len; i++) {
            if(valley > prices[i]) {
                valley = prices[i];
            } else if(valley < prices[i]) {
                profit = Math.max(profit, prices[i] - valley);
            }
        }
        return profit;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[2,1,2,0,1]
Output:
2
Expected:
1
*/
