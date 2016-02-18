public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)  return false;
        
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        for(int j = 2; j < lenP + 1; j++) {
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
         
        for(int i = 1; i < lenS + 1; i++) {
            for(int j = 1; j < lenP + 1; j++) {
                int is = i - 1;
                int jp = j - 1;
                char cs = s.charAt(is);
                char cp = p.charAt(jp);
                
                if(cp == '*') {
                    // .* matches zero preceding elements
                    if(dp[i][j-2]) {
                        dp[i][j] = true;
                    }
                    // .* matches one or more preceding elements
                    else if(j > 1 && dp[i-1][j]) {
                        dp[i][j] = isMatch(cs, p.charAt(j - 2));
                    }
                } else {
                    dp[i][j] = dp[is][jp] && (isMatch(cs, cp));
                }
            }
        }
        return dp[lenS][lenP];
    }
    
    private boolean isMatch(char cs, char cp) {
        if(cp == '.')   return true;
        else            return cs == cp;
    }
}
