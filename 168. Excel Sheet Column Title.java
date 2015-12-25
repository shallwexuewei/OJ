public class Solution {
    public String convertToTitle(int n) {
        if(n < 1) {
            return "";
        }
        return convertToTitle(n-1, "");
    }
    
    private char int2char(int n) {
        return (char)('A' + n);
    }
    
    private String convertToTitle(int n, String suffix) {
        if(n < 26) {
            suffix = int2char(n) + suffix;
            return suffix;
        }
        
        suffix = int2char(n%26) + suffix;
        return convertToTitle(n/26-1, suffix);
    }
}

/*
 Wrong Answer More Details 

Input:
52
Output:
"B@"
Expected:
"AZ"
*/
