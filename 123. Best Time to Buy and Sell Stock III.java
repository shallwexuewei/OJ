public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) {
            return 0;
        }
        
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        
        // the ith value in left array means the maximum profit 
        // that could be achieved to sell the stock at prices[i]
        int[] left = new int[len];
        
        int valley = prices[0];
        left[0] = 0;
        for(int i = 1; i < len; i++) {
            if(valley > prices[i]) {
                valley = prices[i];
            }    
            left[i] = Math.max(left[i-1], prices[i]-valley);
        }
        
        // right to left;
        int peak = prices[len-1];
        int res = 0;
        for(int i = len-2; i > -1; i--) {
            if(peak < prices[i]) {
                peak = prices[i];
            }
            // the following function seems that we could buy the stock when we sell the stock
            // actually it's the situation that only one tranzaction is enough to make the largest profit.
            res = Math.max(res, left[i] + peak - prices[i]);
        } 
        
        return res;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2,4,2,5,7,2,4,9,0]
Output:
12
Expected:
13
Submission Result: Wrong Answer More Details 

Input:
[2,1,2,0,1]
Output:
1
Expected:
2
*/
