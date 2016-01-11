public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if(matrix == null)  return;
        
        int R = matrix.length;
        if(R == 0)          return;
        
        int C = matrix[0].length;
        
        sums = new int[R+1][C+1];
        for(int r = 1; r <= R; r++) {  
            for(int c = 1; c <= C; c++) {
                sums[r][c] = sums[r][c-1] + sums[r-1][c] - sums[r-1][c-1] + matrix[r-1][c-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // cornew cases: Illegal arguments, sums isn't initialized
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
