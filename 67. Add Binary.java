public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null) {
            return "";
        }
        
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        
        int c = 0;
        StringBuilder res = new StringBuilder();
        while(ia >= 0 || ib >= 0) {
            int tmp = c;
            if(ia >= 0 ) {
                if(a.charAt(ia) == '1'){
                    tmp++;
                }
                ia--; 
            }
            if(ib >= 0) {
                if(b.charAt(ib) == '1'){
                    tmp++;
                }
                ib--;
            }
            if(tmp >= 2) {
                tmp -= 2;
                c = 1;
            } else {
                c = 0;
            }
            res.append(tmp);
        }
        if(c == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 21: java.lang.StringIndexOutOfBoundsException: String index out of range: 1
Last executed input:
"11"
"1"
*/
