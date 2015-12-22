public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        
        int[] left = new int[len];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            if(min > prices[i]) {
                min = prices[i];
            }
            left[i] = min;
        }
        
        int max = Integer.MIN_VALUE;
        int res = max;
        for(int i = len - 1; i > -1; i--) {
            if(max < prices[i]) {
                max = prices[i];
                if(max - left[i] > res){
                    res = max-left[i];
                }
            } 
        }
        return res;
    }
}
