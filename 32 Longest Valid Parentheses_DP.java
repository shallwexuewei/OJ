public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        
        int[] dp = new int[len+1];
        
        if(len < 2) {
            return 0;
        }
        int maxLen = 0;
        
        dp[0] = 0;
        if(s.charAt(1) == ')' && s.charAt(0) == '('){
            dp[1] = 2;
            maxLen = 2;
        }
        
        for(int i = 2; i < len; i++){
            if(s.charAt(i) == '(') {
                dp[i] = 0;
            }
            else {
                // ')'
                if(s.charAt(i-1) == '(') {
                    //System.out.println(s);
                    dp[i] = dp[i-2] + 2;
                }
                else{
                    // "))"
                    int left = i-dp[i-1]-1;
                    if(left > -1 && s.charAt(left) == '(') {
                        dp[i] = i-left+1;
                        if(left-1 > -1){
                            dp[i] += dp[left-1];
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
                
            }
            /*
            for(int j = 0; j < len; j++) {
                System.out.print(dp[j]+",");
            }
            System.out.println();
            */
        }
        return maxLen;
    }
}
