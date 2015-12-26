public class Solution { 
    
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }  
        
        int len = s1.length();
        if(len != s2.length())  return false;
        
        if(s1.equals(s2))       return true;
        
        int[] cnts = new int[26];
        for(int i = 0; i < len; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(cnts[i] != 0) {
                return false;
            }   
        }
        
        for(int i = 1; i < len; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && 
            isScramble(s1.substring(i, len), s2.substring(i, len))) {
                return true;
            }
            if(isScramble(s1.substring(0, i), s2.substring(i, len)) && 
            isScramble(s1.substring(i, len), s2.substring(0, i))) {
                return true;
            }
        }
        
        return false;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"ab"
"ba"
Output:
false
Expected:
true
*/
