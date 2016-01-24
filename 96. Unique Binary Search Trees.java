public class Solution {
    public int numTrees(int n) {
        if(n < 1)   return 0;
        if(n == 1)  return 1;
        
        int[] memos = new int[n+1];
        
        memos[0] = 1;
        memos[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                memos[i] += memos[j]*memos[i-j-1];
            }
        }
        return memos[n];
    }
}
