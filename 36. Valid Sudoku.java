public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null)   return false;
        
        int R = board.length;
        if(R == 0)          return false;
        
        int C = board[0].length;
        if(C == 0)          return false;
        
        for(int r = 0; r < R; r++) {
            boolean[] existed = new boolean[10];
            for(int c = 0; c < C; c++) {
                if(board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0';
                if(existed[val]) {
                    return false;
                }
                existed[val] = true;
            }
        }
        
        for(int c = 0; c < C; c++) {
            boolean[] existed = new boolean[10];
            for(int r = 0; r < R; r++) {
                if(board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0';
                if(existed[val]) {
                    return false;
                }
                existed[val] = true;
            }
        }
        
        for(int r0 = 0; r0 < R; r0 += 3) {
            for(int c0 = 0; c0 < R; c0 += 3) {
                boolean[] existed = new boolean[10];
                for(int r = 0; r < 3; r++) { 
                    for(int c = 0; c < 3; c++) {
                        if(board[r0+r][c0+c] == '.') {
                            continue;
                        }
                        int val = board[r0+r][c0+c] - '0';
                        if(existed[val]) {
                            return false;
                        }
                        existed[val] = true;
                    }
                }
            }
        }
        
        return true;
    }
}
