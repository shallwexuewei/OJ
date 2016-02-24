public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i-1; j >= 0 ; j--) {
                if(canBreak[j] && wordDict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
