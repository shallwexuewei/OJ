public class Solution {
    public int[][] generateMatrix(int n) {
        if(n < 0)   return null;
        
        int[][] result = new int[n][n];
        
        int r = 0;
        int c = 0;
        int direction = 0;
        int hi = n - 1;
        int lo = 0;
        for(int i = 1; i <= n*n; i++) {
            result[r][c] = i;
            if(direction == 0) {// left-> right
                if(c == hi) {
                    direction = 1;
                    r++;
                } else {
                    c++;
                }
            }
            else if(direction == 1) { // up -> down
                if(r == hi) {
                    direction = 2;
                    c--;
                    hi--;
                } else {
                    r++;
                }
            } 
            else if(direction == 2) { // right -> left
                if(c == lo) {
                    direction = 3;
                    r--;
                    lo++;
                } else {
                    c--;
                }
            }
            else { // down -> up
                if(r == lo) {
                    direction = 0;
                    c++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
