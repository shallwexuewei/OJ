public class Solution {
    public int numSquares(int n) {
        
        double sqrt = Math.sqrt(n);
        if(sqrt * sqrt == n) {
            return 1;
        } else {
            int min = n;
            for(int i = (int) sqrt; i > 0; i--) {
                int temp = numSquares(n-i*i);
                if(temp != 0) {
                    if(min > temp + 1) {
                        min = temp + 1;
                    }
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
*/
