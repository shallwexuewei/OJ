public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) {
            return 0;
        }
        
        int rows = matrix.length;
        if(rows == 0) {
            return 0;
        }
        
        int cols = matrix[0].length;
        if(cols == 0) {
            return 0;
        }
        
        int[] edges = new int[cols];
        edges[0] = (matrix[0][0] == '1')? 1: 0;
        int max = edges[0];
        for(int c = 1; c < cols; c++) {
            if(matrix[0][c] == '1') {
                edges[c] = 1;
            } else {
                edges[c] = 0;
            }
            if(edges[c] > max) {
                max = edges[c];
            }
        } 
        
        int topLeft; 
        for(int r = 1; r < rows; r++) {
            topLeft = edges[0];
            if(matrix[r][0] == '1') {
                edges[0] = 1;
            } else {
                edges[0] = 0;
            }
            
            for(int c = 1; c < cols; c++) {
                int tmp = edges[c];
                if(matrix[r][c] == '1') { 
                    if(c > 0) {
                        edges[c] = Math.min(edges[c], topLeft); // the last row's edges[c], and edges[c-1]
                        edges[c] = Math.min(edges[c], edges[c-1]); // current row's edges[c-1] 
                        edges[c]++;
                    }  
                    
                    if(edges[c] > max) {
                        max = edges[c];
                    }
                    
                } else {
                    edges[c] = 0;
                }
                topLeft = tmp;
            }
        }
        return max*max;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
["0001","1101","1111","0111","0111"]
Output:
4
Expected:
9

Submission Result: Wrong Answer More Details 

Input:
["11"]
Output:
0
Expected:
1
*/
