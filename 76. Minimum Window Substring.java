public class Solution { 
    
    public String minWindow(String s, String t) { 
        HashMap<Character, Integer> char2cnt = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>(); 
        
        // O(T)
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(char2cnt.containsKey(c))     char2cnt.put(c, char2cnt.get(c) + 1);
            else                            char2cnt.put(c, 1);
        }
        
        // O(S) or O(2S)
        int letterCnt = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(char2cnt.containsKey(c)){
                if(window.containsKey(c))   window.put(c, window.get(c) + 1);
                else                        window.put(c, 1);
                
                if(window.get(c) <= char2cnt.get(c)) {
                    letterCnt++;
                }
            }
            if(letterCnt >= t.length()){
                char cL = s.charAt(left);
                while(!char2cnt.containsKey(cL) || window.get(cL) > char2cnt.get(cL)){
                    if(window.containsKey(cL)){
                        window.put(cL, window.get(cL)-1);
                    }
                    left++;
                    cL = s.charAt(left);
                }
                if(min > right - left + 1) {
                    min = right - left + 1;
                    res = s.substring(left, right + 1);
                }
            }
        } 
        return res;
    } 
}
 
/*
Submission Result: Wrong Answer More Details 

Input:
"bdab"
"ab"
Output:
"bda"
Expected:
"ab"
*/
