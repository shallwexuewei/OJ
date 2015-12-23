public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null)    return 0;
        
        int rows = grid.length;
        if(rows == 0)        return 0;
        
        int cols = grid[0].length;
        if(cols == 0)       return 0;
        
        int[] cnts = new int[cols];
        // fill 1st row
        cnts[0] = grid[0][0];
        for(int c = 1; c < cols; c++) {
            cnts[c] = cnts[c-1] + grid[0][c];
        }
        for(int r = 1; r < rows; r++) {
            cnts[0] += grid[r][0];
            for(int c = 1; c < cols; c++) {
                if(cnts[c] > cnts[c-1]) {
                    cnts[c] = cnts[c-1] + grid[r][c]; // left to right
                }
                else {
                    cnts[c] += grid[r][c];          // or up to down
                }
            }
        }
        return cnts[cols-1];
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[[1,2],[1,1]]
Output:
2
Expected:
3

Submission Result: Wrong Answer More Details 

Input:
[[1,3,1],[1,5,1],[4,2,1]]
Output:
5
Expected:
7
*/
