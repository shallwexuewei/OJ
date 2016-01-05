public class Solution {
    
    public void solveSudoku(char[][] board) {
        if(board == null)   {
            // throws ...
        }
        
        // 3 int 2 hashset to store the existed value
        HashMap<Integer, boolean[]> row2existed = new HashMap<Integer, boolean[]>();
        HashMap<Integer, boolean[]> col2existed = new HashMap<Integer, boolean[]>();
        HashMap<Integer, boolean[]> grid2existed = new HashMap<Integer, boolean[]>();
        
        int R = board.length;
        int C = board[0].length;
        int nDots = 0;
        for(int r = 0; r < R; r++) {
            boolean[] existed = new boolean[10];
            row2existed.put(r, existed);
            
            for(int c = 0; c < C; c++) {
                if(r == 0) {
                    col2existed.put(c, new boolean[10]);
                }
                int grid = rc2grid(r, c);
                if(!grid2existed.containsKey(grid)){
                    grid2existed.put(grid, new boolean[10]);
                }
                
                char ch = board[r][c];
                if(ch == '.') {
                    nDots++;
                    continue;
                }
                
                int val = ch - '0';
                existed[val] = true;
                col2existed.get(c)[val] = true;
                grid2existed.get(grid)[val] = true;
            }
        }
        
        solveSudoku(board, row2existed, col2existed, grid2existed, nDots, 0, 0);
    } 
    
    private boolean solveSudoku(char[][] board, HashMap<Integer, boolean[]> row2existed, 
        HashMap<Integer, boolean[]> col2existed, HashMap<Integer, boolean[]> grid2existed, int nDots, int r, int c) {
            
        if(nDots == 0) {
            return true;
        }
          
        while(r < 9 && board[r][c] != '.') {
            if(c == 8) {
                r++;
                c = 0;
            } else {
                c++;
            } 
        }
        
        int grid = rc2grid(r, c);
        boolean[] rowE = row2existed.get(r);
        boolean[] colE = col2existed.get(c);
        boolean[] gridE = grid2existed.get(grid);
        ArrayList<Integer> valids = getValid(rowE, colE, gridE);
        if(valids.isEmpty()){
            return false;
        }
        
        for(int val:valids) {
            board[r][c] = (char)(val + '0');
            rowE[val] = true;
            colE[val] = true;
            gridE[val] = true;
            if(solveSudoku(board, row2existed, col2existed, grid2existed, nDots - 1, r, c)){
                return true;
            }
            rowE[val] = false;
            colE[val] = false;
            gridE[val] = false;
            
        }
        
        board[r][c] = '.';
        return false;
    }  
    
    private ArrayList<Integer> getValid(boolean[] e1, boolean[] e2, boolean[] e3) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 1; i < 10; i++) {
            if(!e1[i] && !e2[i] && !e3[i]) {
                res.add(i);
            }
        }
        return res;
    }
    
    private int rc2grid(int r, int c) {
        return r/3*3 + c/3;
    }
}
