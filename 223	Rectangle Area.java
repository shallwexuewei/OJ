public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        if(A == C && B == D) {
            return (G-E)*(H-F);
        } 
        if(G == E && H == F) {
            return (C-A)*(D-B);
        }
        
        int lx = Math.max(A, E);
        int rx = Math.min(C, G);
        int uy = Math.min(D, H);
        int by = Math.max(F, B);
        int res = (C-A)*(D-B) + (G-E)*(H-F);
        if(lx >= rx || uy <= by) {
            return res;
        } else {
            return res - (rx - lx) * (uy - by);
        }
    }
}
