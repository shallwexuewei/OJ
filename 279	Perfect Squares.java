public class Solution {
    
    public int numSquares(int n) {
        int[] memos = new int[n];
        return numSquares(n, memos);
    }
    
    private int numSquares(int n, int[] memos) { 
        int sqrt = (int) Math.sqrt(n);
        if(sqrt * sqrt == n) {
            return 1;
        } else {
            int min = n;
            for(int i =  sqrt; i > 0; i--) {
                int val = n - i*i;
                int temp = memos[val];
                if(temp == 0) {
                    temp = numSquares(val, memos);
                    memos[val] = temp;
                }
                if(min > temp + 1) {
                    min = temp + 1;
                }
            }
            return min;
        }
    }
}

/*
Submission Result: Time Limit Exceeded More Details 

Last executed input:
229


Submission Result: Wrong Answer More Details 

Input:
11
Output:
1
Expected:
3
*/
