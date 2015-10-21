public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        
        int lefts = 0;
        int[] pos = new int[len];
        int maxLen = 0;
        int last = -1;
        
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') {
                pos[lefts] = i;
                lefts++;
            }
            else {
                // only ')'
                if(lefts == 0) {
                    last = i;
                }
                else {
                    lefts--;
                    if(lefts == 0) {
                        maxLen = Math.max(maxLen, i-last);
                    } else {
                        maxLen = Math.max(maxLen, i-pos[lefts-1]);
                    }
                    
                }
            }
            
        }
        return maxLen;
    }
}
