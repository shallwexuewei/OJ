public class Solution {
    public int maximalRectangle(char[][] matrix) {
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
        
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];
        Arrays.fill(right, cols);
        
        int res = 0;
        for(int r = 0; r < rows; r++) {
            int curLeft = 0;
            int curRight = cols;
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == '1') {
                    left[c] = Math.max(left[c], curLeft);
                    height[c]++;
                } else {
                    curLeft = c + 1;
                    left[c] = 0;
                    height[c] = 0;
                }
            }
            for(int c = cols-1; c > -1; c--) {
                if(matrix[r][c] == '1') {
                    right[c] = Math.min(right[c], curRight );
                } else {
                    right[c] = cols;
                    curRight = c;
                }
                res = Math.max(res, height[c]*(right[c] - left[c]));
            }
        }
        return res;
    }
}
