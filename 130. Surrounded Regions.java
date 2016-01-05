public class Solution {
    public void solve(char[][] board) {
        if(board == null)   return;
        
        int R = board.length;
        if(R == 0)          return;
        
        int C = board[0].length;
        if(C == 0)          return;
        
        LinkedList<int[]> q = new LinkedList<int[]>();
        int[] p = new int[2];
        
        for(p[0] = 0; p[0] < R; p[0]++) {
            p[1] = 0;
            judge(board, p, q);
            p[1] = C-1;
            judge(board, p, q);
        }
        for(p[1] = 1; p[1] < C-1; p[1]++) {
            p[0] = 0;
            judge(board, p, q);
            p[0] = R-1;
            judge(board, p, q);
        }
        
        //加了这句代码就过不了第二个样例了。。。if(q.isEmpty())     return;
        
        while(!q.isEmpty()){
            p = q.removeFirst(); 
            if(p[0] > 0) {
                p[0]--;
                judge(board, p, q);
                p[0]++;
            }
            if(p[0] < R-1) {
                p[0]++;
                judge(board, p, q);
                p[0]--;
            }
            if(p[1] > 0) {
                p[1]--;
                judge(board, p, q);
                p[1]++;
            }
            if(p[1] < C-1) {
                p[1]++;
                judge(board, p, q);
                p[1]--;
            }
        }
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) { 
                if(board[r][c] == 'B') {
                    board[r][c] = 'O';
                } else if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
    
    private void judge(char[][] board, int[] p, LinkedList<int[]> q) { 
        if(board[p[0]][p[1]] == 'O') { 
            board[p[0]][p[1]] = 'B';
            q.add(p.clone());
        }
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
["XO","OX"]
Output:
["XO","XX"]
Expected:
["XO","OX"]

Submission Result: Wrong Answer More Details 

Input:
["XXX","XOX","XXX"]
Output:
["XXX","XOX","XXX"]
Expected:
["XXX","XXX","XXX"]
*/
