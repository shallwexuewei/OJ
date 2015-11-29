public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int ra = A.length;
        int ca = A[0].length;
        int rb = B.length;
        int cb = B[0].length;
        
        
        boolean[] zeroCols = new boolean[cb];
        Arrays.fill(zeroCols, true);
        for(int c = 0; c < cb; c++) {
            for(int r = 0; r < rb; r++) {
                if(B[r][c] != 0) {
                    zeroCols[c] = false;
                    break;
                }
            }
        }
        
        int[][] ret = new int[ra][];
        for(int r = 0; r < ra; r++) {
            boolean zeroRow = true;
            for(int i = 0; i < ca; i++) {
                if(A[r][i] != 0) {
                    zeroRow = false;
                    break;
                }
            } 
            
            ret[r] = new int[cb];
            for(int c = 0; c < cb; c++) { 
                if(zeroRow || zeroCols[c]) {
                    ret[r][c] = 0;
                    continue;
                }
                for(int i = 0; i < ca; i++) {
                    ret[r][c] += A[r][i]*B[i][c];
                }
            }
        }
        
        return ret;
    }
} 
