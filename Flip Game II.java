public class Solution {
    public boolean canWin(String s) {
        int len = s.length();
        
        return canWin(s, len);
    }
    
    private boolean canWin(String s, int len) { 
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' && s.charAt(i-1) == '+' ){
                if(!canWin(s.substring(0, i-1) + "--" + s.substring(i+1, s.length()), len)) {
                    return true;
                }
            }
        }
        return false;
    }
} 
