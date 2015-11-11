public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // don't forget the corner case!!!
        if(wordDict.isEmpty()){
            return false;
        }
        
        HashMap<Character, LinkedList<String>> char2word = new HashMap<Character, LinkedList<String>>();
        for(String word:wordDict) {
            char c = word.charAt(0);
            if(char2word.containsKey(c) ){
                char2word.get(c).add(word);
            } else {
                LinkedList<String> list = new LinkedList<String>();
                list.add(word);
                char2word.put(c, list);
            } 
        }
        return isMatch(s, 0, char2word);
    }
    
    private boolean isMatch(String s, int i, HashMap<Character, LinkedList<String>> char2word) {
        int subLen = s.length() - i;
        // base case
        if(subLen == 0) {
            return true;
        }
        
        char c = s.charAt(i);
        LinkedList<String> candidates = char2word.get(c);
        // don't forget the corner case!!! ANd do not use isEmpty!!! because it is null!!!
        if(candidates == null){
            return false;
        }
        for(String word:candidates) {
            int len = word.length();
            if(subLen >= len) {
                if(s.substring(i, i+len).equals(word)) {
                    // don't directly return isMatch(s, i+len, char2word)!!!!
                    if( isMatch(s, i+len, char2word)) {
                        return true;
                    } 
                }
            }
        }
        return false;
    }
}

/*
test case:
a, [""]
a, ["b"] Time Limit Exceeded 
*/
