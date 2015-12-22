public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) {
            return 0;
        }
        
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        
        // find valley
        int i = 1;
        while(i < len && prices[i] <= prices[i-1]) {
            i++;
        }
        
        if(i == len) {
            return 0;
        }
        
        // now i-1 is valley
        int valley = prices[i-1];
        int top1 = 0;
        int top2 = 0;
        while(i < len) {
            // find peak;
            while(i < len && prices[i] > prices[i-1]) {
                i++;
            }
            
            // i-1 is peak
            int prof = prices[i-1] - valley;
            if(prof > top2) {
                top2 = prof;
            }
            if(top2 > top1) {
                int tmp = top2;
                top2 = top1;
                top1 = tmp;
            }
            
            // find valley
            while(i < len && prices[i] <= prices[i-1]) {
                i++;
            } 
            valley = prices[i-1];
        }
        
        return top1 + top2;
        
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

*/
