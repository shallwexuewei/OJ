public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0 || board == null) {
            return false;
        }
        
        int R = board.length;
        int C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        // traverse and dfs
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(dfs(board, word, r, c, 0, visited, R, C))    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int idx, boolean[][] visited, int R, int C) {
        if(board[r][c] == word.charAt(idx)) {
            idx++;
            if(idx == word.length()){
                return true;
            }
            
            visited[r][c] = true;
            // left
            if(c > 0 && !visited[r][c-1]) {
                if(dfs(board, word, r, c - 1, idx, visited, R, C))  return true;;
            }
            // right
            if(c < C - 1&& !visited[r][c+1]) {
                if(dfs(board, word, r, c + 1, idx, visited, R, C))  return true;
            }
            // up
            if(r > 0 && !visited[r-1][c]) {
                if(dfs(board, word, r - 1, c, idx, visited, R, C))  return true;
            }
            // down
            if(r < R - 1 && !visited[r+1][c]) {
                if(dfs(board, word, r + 1, c, idx, visited, R, C))  return true;
            }
            
            
            // backtracking
            visited[r][c] = false;
        }
        return false;
    }
}
