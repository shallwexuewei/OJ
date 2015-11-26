public class Solution {
    public boolean wordPatternMatch(String pattern, String str) { 
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> words = new HashSet<String>();
        return match(pattern, str, 0, 0, map, words);
        
    }
    
    private boolean match(String pattern, String str, int pi, int si, HashMap<Character, String> map, HashSet<String> words) {
        if(pi == pattern.length()) {
            return si == str.length();
        } else if(si == str.length()) {
            return false;
        }
        
        char c = pattern.charAt(pi);
        if(map.containsKey(c)) {
            String word = map.get(c);
            for(int i = 0; i < word.length(); i++) {
                // dont forget si + i < str.length()
                if(si + i < str.length() && str.charAt(si + i) != word.charAt(i)) {
                    return false;
                }
            }
            return match(pattern, str, pi + 1, si + word.length(), map, words);
        } else {
            // new c
            for(int i = si + 1; i <= str.length(); i++ ) {
                String word = str.substring(si, i);
                // one word cannot be mapped to different pattern.
                if(words.contains(word)) {
                    continue;
                }
                map.put(c, word);
                words.add(word);
                if(match(pattern, str, pi + 1, i, map, words)) {
                    return true;
                }
                map.remove(c);
                words.remove(word);
            }
            return false;
        }
    }
}

/*
 Wrong Answer More Details 

Input:
"ab"
"aa"
Output:
true
Expected:
false

From the above test case, we know that one word cannot be mapped to different pattern.
*/
