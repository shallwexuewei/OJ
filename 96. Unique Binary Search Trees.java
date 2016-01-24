public class Solution {
    public int numTrees(int n) {
        int[] memos = new int[n+1];
        return numTrees(n, memos);
    }
    
    private int numTrees(int n, int[] memos) {
        if(n == 1) {
            return 1;
        } 
        if(memos[n] > 0) {
            return memos[n];
        }
        
        
        int sum = 0;
        int half = n/2;
        
        sum += numTrees(n-1, memos);
        int left = 1;
        int right = n - 2;
        for( ; left < half; left++) {
            sum += numTrees(left, memos)*numTrees(right, memos);
            right--;
        }
        sum *= 2;
        if(n%2 == 1) {
            int temp = numTrees(half, memos);
            sum += temp*temp;
        }
        memos[n] = sum;
        return sum;
    }
}
