public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) {
            return false;
        }
        
        String[] words = str.split(" ");
        if(words.length != pattern.length()) { 
            return false;
        }
        
        String[] char2word = new String[26];
        HashSet<String> wordSet = new HashSet<String>();
        for(int i = 0; i < words.length; i++) {
            int charIdx = pattern.charAt(i) - 'a';
            if(char2word[charIdx] == null) {
                if(wordSet.contains(words[i])) {
                    return false;
                }
                char2word[charIdx] = words[i];
                wordSet.add(words[i]);
            } else {
                if(char2word[charIdx].equals(words[i]) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}
