public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
        
        // use dict to store the last position of the char 
        HashMap<Character, Integer> char2i = new HashMap<Character, Integer>();
        
        int left = 0;
        int max = -1;
        
        // window: double pointers, 
        // right pointer: i
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if(char2i.containsKey(c)){
                int lastPos = char2i.get(c);
                if(lastPos + 1> left) {
                    left = lastPos + 1;
                }
            }
            char2i.put(c, i); 
            if(max < i - left + 1) {
                max = i - left + 1;
            }
        }
        return max;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"abba"
Output:
3
Expected:
2
*/
