public class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
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
        if(parent[i] != i) {
            parent[i] = parent[parent[i]];
            return find(parent, parent[i]);
        }
        return i;
    }
}
