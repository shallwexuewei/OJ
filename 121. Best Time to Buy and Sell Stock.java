public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 1) {
            return 0;
        }
        
        int[] min = new int[len];
        min[0] = prices[0];
        for(int i = 1; i < len; i++) {
            min[i] = Math.min(min[i-1], prices[i]);
        }
        
        int profit = 0;
        for(int i = len-1; i > -1; i--) {
            profit = Math.max(profit, prices[i] - min[i]);
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
