public class Solution {
    
    public int countPrimes(int n) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            double sqrt = Math.sqrt(i);
            boolean isPrime = true;
            for(int j = 2; j < sqrt; j++) {
                if(n%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                cnt++;
            }
        }
        return cnt;
    }
}

/*
test case:
: Time Limit Exceeded More Details 

Last executed input:
499979
*/
