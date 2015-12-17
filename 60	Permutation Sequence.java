public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        
        LinkedList<Integer> candidates = new LinkedList<Integer>();
        for(int i = 1; i < n; i++) {
            fact[i] = fact[i-1] * i;
            candidates.add(i);
        }
        candidates.add(n);
        
        StringBuilder res = new StringBuilder();
        k--;
        for(int i = n-1; i > 0; i--) {
            int c = k/fact[i];
            res.append(candidates.remove(c)); 
            k = k%fact[i];
        }
        res.append(candidates.remove());
        
        return res.toString();
        
    }
}
