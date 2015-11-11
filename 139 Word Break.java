public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        
        boolean[] starts = new boolean[len+1];
        starts[0] = true;
        for(int i = 0; i < len; i++) {
            if(starts[i] == false) {
                continue;
            }
            
            for(String word:wordDict) {
                int wordLen = word.length();
                if(wordLen + i <= len && word.equals(s.substring(i, i+wordLen))){
                    starts[i+wordLen] = true;
                }
            }
        }
        return starts[len];
    } 
}

/*
test case:
a, [""]
a, ["b"]
*/
