public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || n < 1) {
            // ..
        }
        
        int k = primes.length;
        if(k == 0) {
            // ...
        }
        
        
        int[] multiples = Arrays.copyOf(primes, k);
        
        int[] indices = new int[k];
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        for(int i = 1; i < n; i++) {
            int min = multiples[0];
            for(int j = 1; j < k; j++) {
                if(min > multiples[j]) {
                    min = multiples[j];
                }
            }
            ugly[i] = min;
            
            for(int j = 0; j < k; j++) {
                if(multiples[j] == min) {
                    indices[j]++;
                    multiples[j] = primes[j] * ugly[indices[j]];
                }
            }
        }
        return ugly[n-1];
    }
}
