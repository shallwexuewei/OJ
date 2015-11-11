public class Solution {
    public static boolean matchChar(char c, char p) {
        return (p == '?' || p == c);
    }
    
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int si = 0;
        int pi = 0;
        
        int lenS = s.length();
        int lenP = p.length();
        
        int preS = 0;
        int preP = 0;
        
        boolean back = false;
        
        while (si < lenS) {
            if (pi < lenP && matchChar(s.charAt(si), p.charAt(indexP))) {
                si++;
                pi++;
            } else if (pi < lenP && p.charAt(pi) == '*') { // e.g. s:"aa", p:"*"
            
                // the function of continous '*' like "*****" equals to the single '*'
                while (pi < lenP && p.charAt(pi) == '*') {
                    pi++;
                }
                
                //P的最后一个是 *，表示可以匹配任何字符串
                if (indexP == lenP) {
                    return true;
                }
                
                // now we use '*' to match empty string
                // but we record the positions, so if the assumption is wrong
                // we can go back to the position to use '*' to match longer string
                // 记录下这个匹配位置。
                back = true;
                preS = si;
                preP = pi;
            } else if (back) { // there is '*' before, we could try to use it to match longer string
                si = ++preS;
                pi = preP;
            } else { // s is larger than p, e.g. s:"aa", p:"a"
                return false;
            }
        }
        
        // 跳过末尾的所有的*.
        while (pi < lenP && p.charAt(pi) == '*') {
            pi++;
        }
        
        if (si == lenS && indexP == lenP) {
            return true;
        }

        return false;
    }
}
