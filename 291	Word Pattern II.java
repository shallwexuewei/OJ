public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null) {
            return false;
        }
        
        String[] char2word = new String[26];
        HashSet<String> wordSet = new HashSet<String>();
        
        return dfs(pattern, str, char2word, wordSet, 0, 0);
    }
    
    private boolean dfs(String pattern, String str, String[] char2word, HashSet<String> wordSet, int strIdx, int patternIdx) {
        if(pattern.length() == patternIdx) {
            System.out.println(str.length() + ", " + strIdx);
            return str.length() == strIdx;
        }
        int charIdx = pattern.charAt(patternIdx) - 'a';
        int restLen = pattern.length() - patternIdx - 1;
        if(char2word[charIdx] == null) {
            for(int end = strIdx+1; end <= str.length() - restLen; end++) {
                String subStr = str.substring(strIdx, end);
                //System.out.println(subStr);
                if(wordSet.contains(subStr)) {
                    continue;
                }
                char2word[charIdx] = subStr;
                wordSet.add(subStr);
                if(dfs(pattern, str, char2word, wordSet, end, patternIdx + 1)) {
                    return true;
                }
                wordSet.remove(subStr);
                char2word[charIdx] = null;
            }
            return false;
        } else {
            String word = char2word[charIdx];
            int end = strIdx + word.length();
            if(end > str.length()) {
                return false;
            }
            String subStr = str.substring(strIdx, end);
            if(word.equals(subStr)) {
                //System.out.println(strIdx + ", " + end + ", " + word + ", " + subStr);
                return dfs(pattern, str, char2word, wordSet, end, patternIdx+1);
            } else {
                return false;
            }
        }
    }
}
