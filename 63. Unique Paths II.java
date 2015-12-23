public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null)    return 0;
        
        int rows = obstacleGrid.length;
        if(rows == 0)               return 0;
        
        int cols = obstacleGrid[0].length;
        if(cols == 0)               return 0;
        
        int[] cnts = new int[cols];
        // fill 1st row
        cnts[0] = 1 - obstacleGrid[0][0];
        for(int c = 1; c < cols; c++) {
                if(obstacleGrid[0][c] == 1) {
                    cnts[c] = 0;
                } else {
            cnts[c] = cnts[c-1]; 
                }
        }
        for(int r = 1; r < rows; r++) {
            if(cnts[0] == 1 && obstacleGrid[r][0] == 1) {
                cnts[0] = 0;
            }
            for(int c = 1; c < cols; c++) {
                if(obstacleGrid[r][c] == 1) {
                    cnts[c] = 0;
                } else {
                    cnts[c] += cnts[c-1]; // left to right
                }
            }
        }
        return cnts[cols-1];
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[[1,0]]
Output:
1
Expected:
0
*/
