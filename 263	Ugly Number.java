public class Solution {
    public boolean isUgly(int num) {
        // remember corner case!!!
        if(num < 1) {
            return false;
        }
        
        // base case;
        if(num == 1) {
            return true;
        }
        int[] memo = new int[num];
        Arrays.fill(memo, -1);
        int[] factors = {2, 3, 5};
        return isUgly(num, memo, factors);
    }
    
    private boolean isUgly(int num, int[] memo, int[] factors){
        for(int i: factors) {
            if(num%i == 0) {
                if(isUgly(num/i)){
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Runtime Error Message:
Line 12: java.lang.OutOfMemoryError: Java heap space
Last executed input:
214797179
*/
