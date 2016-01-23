public class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        int len = edges.length;
        if(len != n - 1) {
            return false;
        }
        
        for(int i = 0; i < len; i++) {
            int root0 = find(parent, edges[i][0]);
            int root1 = find(parent, edges[i][1]);
            
            if(root0 == root1) {
                return false;
            }
            
            parent[root1] = root0;
        }
        
        
        return true;
    }
    
    private int find(int[] parent, int i) {
        if(parent[i] != -1) {
            return find(parent, parent[i]);
        }
        return i;
    }
}
