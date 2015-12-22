
/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(prices == null) return 0;
        
        int len = prices.length;
        if(len == 0)    return 0;
        
        if(k >= len/2) {
            int res = 0;
            for(int i = 1; i < len; i++) {
                if(prices[i] > prices[i-1]) {
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }
        
        // use k+1 rows rather than k, to prevent the ArrayIndexOutOfBoundsException
        // in dp[i-1][j]
        int[] dp = new int[len];
        for(int i = 1; i <= k; i++) {
            int localMax = -prices[0]; 
            for(int j = 1; j < len;  j++) {
                int last_dp_j = dp[j];
                dp[j] = Math.max(dp[j-1], prices[j] + localMax);
                localMax = Math.max(localMax, last_dp_j - prices[j]);  
            }
        }
        
        return dp[len-1];
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 21: java.lang.ArrayIndexOutOfBoundsException: -1
Last executed input:
1
[1]

Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 22: java.lang.ArrayIndexOutOfBoundsException: -1
Last executed input:
1
[1,2]

Submission Result: Wrong Answer More Details 

Input:
2
[3,2,6,5,0,3]
Output:
0
Expected:
7
*/
