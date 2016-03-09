public class Solution {
    public int climbStairs(int n) {
        if(n < 1) {
            // throw ... return 0;
            
        }
        else if(n < 2) {
            return 1;
        }
        
        /*
        int[] ways = new int[n];
        ways[0] = 1; // ways to climb to 1
        ways[1] = 2; // ways to climb to 2
        for(int i = 2; i < n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n-1];
        */
        
        int pre2 = 1;
        int pre1 = 2;
        for(int i = 2; i < n; i++) {
            int cur = pre1+pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
        
    }
}
