public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        if(R == 0)  return 0;
        
        int C = matrix[0].length;
        if(C == 0)  return 0;
        
        int[][] memos = new int[R][C];
        int max = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                max = Math.max(max, 1+dfs(r, c, matrix, R, C, memos));
            }
        }
        return max;
    }
    
    private int dfs(int r, int c, int[][] matrix, int R, int C, int[][] memos) {
        if(memos[r][c] > 0) {
            return memos[r][c];
        }
        
        int max = 0;
        if(r + 1 < R && matrix[r+1][c] > matrix[r][c]) {
            max = Math.max(max, 1 + dfs(r+1, c, matrix, R, C, memos));
        }
        if(c + 1 < C && matrix[r][c+1] > matrix[r][c]) {
            max = Math.max(max, 1 + dfs(r, c+1, matrix, R, C, memos));
        }
        if(r - 1 > -1 && matrix[r-1][c] > matrix[r][c]) {
            max = Math.max(max, 1 + dfs(r-1, c, matrix, R, C, memos));
        }
        if(c - 1 > -1 && matrix[r][c-1] > matrix[r][c]) {
            max = Math.max(max, 1 + dfs(r, c-1, matrix, R, C, memos));
        }
        memos[r][c] = max;
        return max;
    }
}
