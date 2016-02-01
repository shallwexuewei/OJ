public class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        
        boolean[][] dp = new boolean[lenS+1][lenP+1];
        
        dp[0][0] = true;
        for(int j = 1; j <= lenP; j++) {
            char charP = p.charAt(j-1);
            if(charP == '*') {
                if(j == 1 || dp[0][j-2]) {
                    dp[0][j] = true;
                }
            } else {
                dp[0][j] = false;
            }
        }
        
        for(int i = 1; i <= lenS; i++) {
            for(int j = 1; j <= lenP; j++) {
                char charP = p.charAt(j-1);
                char charS = s.charAt(i-1);
                if(charP == '*') {
                    if(dp[i][j-1]) { // '*' here is used as matching one preceding element
                        dp[i][j] = true;
                    } else if(dp[i][j-2]) { // "*" here is used as matching no preceding element
                        dp[i][j] = true;
                    } else if(dp[i-1][j]) {
                        char prevP = p.charAt(j-2);
                        if(charS == prevP) { // e.g. "aa", "a*"
                            dp[i][j] = true;
                        } else if(prevP == '.') {  // e.g. "aa", ".*"
                            dp[i][j] = true;
                        }
                    }
                } else {
                    if(dp[i-1][j-1]) { // when s.substring(0, i-1) matches p.substring(0, j-1)
                        if(charP == '.' || charP == charS) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }
}
