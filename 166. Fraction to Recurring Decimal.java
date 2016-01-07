public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) {
            /* ... */
        }
        if(numerator == 0) {
            return "0";
        }
        
        long n = (long) numerator;
        long d = (long) denominator;
        
        StringBuilder sb = new StringBuilder();
        if(n < 0) {
            n = -n;
            if(d < 0) {
                d = -d;
            }
            else {
                sb.append('-');
            }
        }
        else {
            if(d < 0) {
                d = -d;
                sb.append('-');
            }
        }
        
        long integer = n/d;
        long r = n%d;
        
        
        sb.append(integer);
        if(r==0)    return sb.toString();
        
        sb.append('.');
        
        /* value to position */
        HashMap<Long, Integer> r2pos = new HashMap<Long, Integer>();
        while(r > 0) {
            r *= 10;
            System.out.println(r);
            if(r2pos.containsKey(r)){
                int pos = r2pos.get(r);
                /* ... */
                sb.insert(pos, '(');
                sb.append(')');
                break;
            }
            long val = r/d;
            
            r2pos.put(r, sb.length());
            sb.append(val);
            
            r %= d;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.fractionToDecimal(-1, -2147483648));
    }
}

/*

Submission Result: Wrong Answer More Details 

Input:
1
333
Output:
"0.(0)"
Expected:
"0.(003)"

Submission Result: Wrong Answer More Details 

Input:
1
99
Output:
"0.0(10)"
Expected:
"0.(01)"

Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 39: java.lang.NullPointerException
Last executed input:
1
6

Submission Result: Wrong Answer More Details 

Input:
0
-5
Output:
"-0"
Expected:
"0"

Submission Result: Wrong Answer More Details 

Input:
-1
-2147483648
Output:
"0.000000000000"
Expected:
"0.0000000004656612873077392578125"
*/
