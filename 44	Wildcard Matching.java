public class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        
        for(int j = 1; j <= lenP; j++) {
            if(p.charAt(j-1) == '*')    dp[0][j] = dp[0][j-1];
            else                        break;
        }
        
        for(int i = 1; i <= lenS; i++) {
            for(int j = 1; j <= lenP; j++) {
                char charS = s.charAt(i-1);
                char charP = p.charAt(j-1);
                if(charP == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                if(dp[i-1][j-1]) {
                    if(charS == charP || charP == '?') {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }
}
