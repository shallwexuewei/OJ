public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if(s == null || s.length() == 0 || k < 1) {
            return 0;
        }
        
        HashMap<Character, Integer> char2num = new HashMap<>();
        int maxLen = 1;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(char2num.containsKey(ch)) {
                char2num.put(ch, char2num.get(ch) + 1);
                if(maxLen < i - left + 1) {
                    maxLen = i - left + 1;
                }
            } else if(char2num.size() < k) {
                char2num.put(ch, 1);
                if(maxLen < i - left + 1) {
                    maxLen = i - left + 1;
                }
            } else {
                while(char2num.size() == k) {
                    char leftChar = s.charAt(left);
                    int num = char2num.get(leftChar);
                    if(num == 1) {
                        char2num.remove(leftChar);
                    } else {
                        char2num.put(leftChar, num-1);
                    }
                    left++;
                }
                char2num.put(ch, 1);
            }
        }
        return maxLen;
    }
}
