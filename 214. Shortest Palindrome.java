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
        
        int[] p = new int[len]; // the position fo prefix's end
        int k = 0;
        for (int i = 1; i < len; i++) {
            int j = p[i - 1];
            while (j > 0 && s1.charAt(i) != s1.charAt(j))
                j = p[j - 1];
            if(s1.charAt(i) == s1.charAt(j)) {
                j++;
            }
            p[i] = j;
        }
        
        String rest = s.substring(p[len-1]);
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
