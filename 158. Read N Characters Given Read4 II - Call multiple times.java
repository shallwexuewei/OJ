/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] cache;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n < 1) {
            // throw new ...
        }
        
        int shift = 0;
        int totalLen = 0;
        if(cache != null)   shift = cache.length;
        if(shift > 0) {
            if(n < shift) {
                for(int i = 0; i < n; i++) {
                    buf[i] = cache[i];
                }
                char[] newCache = new char[shift-n];
                for(int i = n; i < shift; i++) {
                    newCache[i-n] = cache[i];
                }
                cache = newCache;
                return n;
            }
            
            // n >= shift
            for(int i = 0; i < shift; i++) {  
                buf[i] = cache[i]; 
            }
            cache = null;
            totalLen += shift;
        } 
        
        n -= shift;
        
        // if n = 1, times = 0
        // if n = 4, times = 0
        // if n = 5, times = 1
        int times = n/4;
        int i = 0;
        for( i = 0; i < times; i++) {
            char[] cs = new char[4];
            int len = read4(cs);
            for(int j = 0; j < len; j++) {
                buf[j +totalLen] = cs[j];
            }
            totalLen += len;
            if(len < 4) {
                break;
            }
        }
        if(i == times) {
            int rest = n%4;
            if(rest != 0) {
                char[] cs = new char[4];
                int len = read4(cs);
                for(int j = 0; j < rest && j < len; j++) {
                    buf[j+ totalLen] = cs[j];
                }
                totalLen += Math.min(rest, len);
                if(rest < len) {
                    cache = new char[len-rest];
                    for(int j = rest; j < len; j++) {
                        cache[j-rest] = cs[j];
                    }
                }
            }
        } 
        return totalLen;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
""
[read(1)]
Output:
["\x00"]
Expected:
[""]

Submission Result: Wrong Answer More Details 

Input:
"ab"
[read(1),read(2)]
Output:
["a",""]
Expected:
["a","b"]

Submission Result: Wrong Answer More Details 

Input:
"ab"
[read(1),read(1),read(1)]
Output:
["a","",""]
Expected:
["a","b",""]

Submission Result: Wrong Answer More Details 

Input:
"ab"
[read(4)]
Output:
[""]
Expected:
["ab"]
*/
