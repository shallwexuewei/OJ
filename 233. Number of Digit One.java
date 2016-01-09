public class Solution {
    public int countDigitOne(int n) {
        int ones = 0; 
        for(long m = 1; m <= n; m *= 10) {
            long div = n/m;
            long rem = n%m;
            ones += (div+8)/10*m;
            if(div%10 == 1) {
                ones += rem + 1;
            } 
        }
        return ones;
    }
}
