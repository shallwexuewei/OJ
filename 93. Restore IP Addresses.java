public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        getIP(s, 0, res, 0, "");
        return res;
    }
    
    // determine if the part of ip is valid or not
    // len:
    //  1: true
    //  2: first one cannot be 0
    //  3: should be less than 255 and the first character cannot be 0
    private boolean valid(String s) {
        int len = s.length();
        if(len > 3) {
            return false;
        }
        if(len == 1) {
            return true;
        } else {
            if(s.charAt(0) == '0') {
                return false;
            }
            if(len == 2) {
                return true;
            } else {
                // len == 3
                int n = Integer.parseInt(s);
                if(n <= 255) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    
    private void getIP(String s, int i, List<String> res, int depth, String prefix){
        // has divided the string to 4 parts, now to check whether to add it into result
        if(depth == 3) {
            if(i >= s.length() || s.length() - i > 3){
                return;
            }
            String sub = s.substring(i, s.length());
            if(valid(sub)) {
                res.add(prefix + sub);
            }
            return;
        }
        
        // the next part of ip can be of 1 digit to 3 digits
        for(int j = i + 1; j < i + 4 && j < s.length(); j++) { 
            String sub = s.substring(i, j);
            if(valid(sub)) { 
                getIP(s, j, res, depth+1, prefix + sub + ".");
            }
        }
    }
}

/*
Runtime Error Message:
Line 13: java.lang.NumberFormatException: For input string: "9245587303"
Last executed input:
"0279245587303"

Input:
"010010"
Output:
["0.1.0.10","0.1.0.10","0.1.1.0","0.10.0.10","0.10.1.0","0.100.1.0","1.0.0.10","1.0.1.0","1.0.1.0","10.0.1.0"]
Expected:
["0.10.0.10","0.100.1.0"]
*/
