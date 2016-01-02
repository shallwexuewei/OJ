public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null)   return s;
        
        int len = s.length();
        if(len == 0)    return s;
        
        String rev = (new StringBuilder(s)).reverse().toString();
        
        StringBuilder sb = new StringBuilder(s);
        sb.append('#');
        sb.append(rev);
        String s1 = sb.toString();
        
        len = 2*len+1;
        int[] dfa = new int[len];
        dfa[0] = 0;
        for(int i = 1; i < len; i++){
            if(s1.charAt(i) == s1.charAt(dfa[i-1])) {
                dfa[i] = dfa[i-1] + 1;
            } else {
                dfa[i] = 0;
            }
        }
         
        String rest = s.substring(dfa[len-1]);
        sb = new StringBuilder(rest);
        sb.reverse();
        sb.append(s); 
        return sb.toString();
    }
}
/*
Submission Result: Wrong Answer More Details 

Input:
"abbacd"
Output:
"dcabbabbacd"
Expected:
"dcabbacd"

Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 18: java.lang.StringIndexOutOfBoundsException: String index out of range: 1
Last executed input:
"a"

Submission Result: Wrong Answer More Details 

Input:
"aacecaaa"
Output:
"aaacecaacecaaa"
Expected:
"aaacecaaa"
*/
