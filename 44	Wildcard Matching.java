public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)  return false;
        
        int sLen = s.length();
        int pLen = p.length();
        
        int sIdx = 0;
        int pIdx = 0;
        int pStar = -1;
        int sStar = -1;
        while(sIdx < sLen) {
            if(pIdx < pLen && p.charAt(pIdx) == '*' ) {
                pStar = pIdx;
                sStar = sIdx;
                pIdx++; // match empty string
            }
            else if(pIdx < pLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')) {
                pIdx++;
                sIdx++;
            } 
            else if(sStar > -1) {
                sStar++;
                sIdx = sStar;
                pIdx = pStar + 1;
            }
            else {
                return false;
            }
        }
        
        while(pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == pLen;
    }
}
