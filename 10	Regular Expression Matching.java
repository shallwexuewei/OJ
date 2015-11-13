public class Solution {
    /*
    as '*' Matches zero or more of the preceding element, we need to pre-look the next char in case of '*'
    */
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
    
    private boolean isMatch(String s, String p, int i1, int i2) {
        int len1 = s.length();
        int len2 = p.length();
        
        /* base case */
        if(i2 == len2) {
            return i1 == len1;
        }
        
        // s and p both has length of more than or equal to 1 
        // case 1: no *, 
        // case 2: *
        // case 3: p.len = 1
        if(i2 == len2 - 1 || p.charAt(i2 + 1) != '*' ) {
            if(i1 == len1) {
                return false;
            }  
            if(p.charAt(i2) == s.charAt(i1) || p.charAt(i2) == '.' ) {
                return isMatch(s, p, i1 + 1, i2 + 1);
            } else {
                return false;
            }
        } else {
            // *
            // case 1: match empty string:
            if(isMatch(s, p, i1, i2 + 2)){
                return true;
            } 
            
            int i = i1;
            while(i < len1 && (p.charAt(i2) == s.charAt(i) || p.charAt(i2) == '.')) {
                if(isMatch(s, p, i + 1, i2 + 2)){
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
"aaa"
"ab*a*c*a"
Output:
false
Expected:
true

Input:
"a"
"ab*"
Output:
false
Expected:
true
*/
