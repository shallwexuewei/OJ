public class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        if(lenT > lenS) return 0;
            
        int[][] memos = new int[lenT+1][lenS+1];
        for(int c = 0; c <= lenS; c++) {
            memos[0][c] = 1;
        }
        for(int c = 1; c <= lenS; c++) {
            for(int r = 1; r <= lenT; r++) {
                memos[r][c] = memos[r][c-1];
                if(s.charAt(c-1) == t.charAt(r-1)){
                    memos[r][c] += memos[r-1][c-1];
                }
            }
        }
        return memos[lenT][lenS];
    }
}
