public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if(matrix == null)  return;
        
        int R = matrix.length;
        if(R == 0)          return;
        
        int C = matrix[0].length;
        
        sums = new int[R][C+1];
        for(int r = 0; r < R; r++) { 
            sums[r][0] = 0;
            for(int c = 0; c < C; c++) {
                sums[r][c+1] = sums[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // cornew cases: Illegal arguments, sums isn't initialized
        
        int sum = 0;
        for(int r = row1; r <= row2; r++) {
            sum += sums[r][col2+1] - sums[r][col1];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
