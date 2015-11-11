public class Solution {
    public boolean isUgly(int num) {
        // remember corner case!!!
        if(num < 1) {
            return false;
        }
        
        // base case;
        if(num == 1) {
            return true;
        }  
        
        while(num%2 == 0) {
            num/=2;
        }
        while(num%3 == 0) {
            num/=3;
        }
        while(num%5 == 0) {
            num/=5;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }
     
}

/*
Runtime Error Message:
Line 12: java.lang.OutOfMemoryError: Java heap space
Last executed input:
214797179
*/
