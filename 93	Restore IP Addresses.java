public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        getIP(s, 0, res, 0, "");
        return res;
    }
    
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
