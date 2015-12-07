public class Solution {
    private boolean valid(String s) {
        int len = s.length();
        if(len > 2) {
            return false;
        } else if (len == 1) {
            if(s.charAt(0) > '0' && s.charAt(0) <= '9'){
                return true;
            } else{
                return false;
            }
        } else {
            // len == 2
            if(s.charAt(0) == '1') {
                return true;
            } else if(s.charAt(0) == '2') {
                if(s.charAt(1) >= '0' && s.charAt(1) <= '6') {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            } 
        }
    }
    
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        for(int i = 0; i < len; i++) { 
            if(valid(s.substring(i, i+1))){
                if(i < 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i-1];
                }
            }
            if(i > 0 && valid(s.substring(i-1, i+1))){
                if(i <= 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len-1];
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 42: java.lang.StringIndexOutOfBoundsException: String index out of range: -1
Last executed input:
"0"
*/
