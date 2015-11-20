public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) return false;
        
        int cols = matrix[0].length;
        if(cols == 0) return false;
        
        return searchMatrix(matrix, target, 0, 0, rows - 1, cols - 1);
    }
    
    private boolean searchMatrix(int[][] m, int target, int r1, int c1, int r2, int c2) { 
        if(r1 > r2 || c1 > r2) return false;
        
        int mr = r1 + (r2 - r1)/2;
        int mc = c1 + (c2 - c1)/2;
        if(m[mr][mc] == target) {
            return true;
        } else if(m[mr][mc] < target) {
            if(searchMatrix(m, target, mr + 1, mc + 1, r2, c2)) return true;
            if(searchMatrix(m, target, r1, mc + 1, mr, c2)) return true;
            if(searchMatrix(m, target, mr + 1, c1, r2, mc)) return true;
        } else { 
            if(searchMatrix(m, target, r1, c1, mr - 1, mc - 1)) return true;
            if(searchMatrix(m, target, r1, mc, mr - 1, c2)) return true;
            if(searchMatrix(m, target, mr, c1, r2, mc - 1)) return true;
        }
        return false;
    }
}
/*
Runtime Error More Details 

Runtime Error Message:
Line 24: java.lang.StackOverflowError
Last executed input:
[[-5]]
-10
*/
