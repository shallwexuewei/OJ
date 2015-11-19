public class Solution {
    /*
    1. all connected
    2. no cycle
    */
    public boolean validTree(int n, int[][] edges) {
        ArrayList<LinkedList<Integer>> neighbors = new ArrayList<LinkedList<Integer>>(n);
        for(int i = 0; i < n; i++) {
            neighbors.add(new LinkedList<Integer>());
        }
        
        for(int[] edge:edges) {
            if(edge[0] < edge[1]) {
                neighbors.get(edge[0]).add(edge[1]);
            } else {
                neighbors.get(edge[1]).add(edge[0]);
            }
        }
        
        
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        q.add(0);
        while(!q.isEmpty()) {
            int current = q.removeFirst();
            
            if(visited.contains(current)) return false;
            
            visited.add(current);
            q.addAll(neighbors.get(current));
        }
        
        if(visited.size() == n) {
            return true;
        } else {
            return false;
        }
        
    }
}
/*
Input:
3
[[2,0],[2,1]]
Output:
false
Expected:
true
*/
