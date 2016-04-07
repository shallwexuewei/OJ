public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int numRow = board.length;
        int numCol = board[0].length;
        for(int r = 0; r < numRow; r++) {
            for(int c = 0; c < numCol; c++) {
                int numLiveNeighbors = countLiveNeighbors(board, r, c);
                if(board[r][c] == 1) {
                    if(numLiveNeighbors == 2 || numLiveNeighbors == 3) {
                        board[r][c] |= 2;
                    }
                } else {
                    if(numLiveNeighbors == 3) {
                        board[r][c] |= 2;
                    }
                }
            }
        }
        for(int r = 0; r < numRow; r++) {
            for(int c = 0; c < numCol; c++) {
                board[r][c] >>>= 1;
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int r0, int c0) {
        int cnt = 0;
        for(int r = Math.max(0, r0-1); r < Math.min(r0+2, board.length); r++) {
            for(int c = Math.max(0, c0-1); c < Math.min(c0+2, board[0].length); c++) {
                cnt += board[r][c] & 1;
            }
        }
        cnt -= board[r0][c0] & 1;
        return cnt;
    }
}
