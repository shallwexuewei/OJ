public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
         
        int i = 1;
        while (i < len && prices[i] <= prices[i-1]) {
            i++;
        }
        
        if(i == len) {
            return 0;
        }
        
        // now prices[i] > prices[i-1]
        int valley = prices[i-1];
        boolean up = true;
        int res = 0;
        while(i < len) {
            // up
            while(i < len && prices[i] > prices[i-1]) {
                i++;
            }
            
            // i-1 is peak
            res += prices[i-1] - valley;
            
            // down;
            while(i < len && prices[i] <= prices[i-1]) {
                i++;
            }
            
            valley = prices[i-1];
        }
        
        return res;
    }
}

/*
test case:
[3,3]
*/
