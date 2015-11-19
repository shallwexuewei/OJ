public class Solution {
    /*
    1. all connected
    2. no cycle
    */
    public boolean validTree(int n, int[][] edges) {
        ArrayList<HashSet<Integer>> neighbors = new ArrayList<HashSet<Integer>>(n);
        for(int i = 0; i < n; i++) {
            neighbors.add(new HashSet<Integer>());
        }
        
        for(int[] edge:edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> q = new LinkedList<Integer>();
        LinkedList<Integer> prevs = new LinkedList<Integer>();
        
        q.add(0);
        prevs.add(-1);
        while(!q.isEmpty()) {
            int current = q.removeFirst();
            int prev = prevs.removeFirst();
            
            if(visited.contains(current)) return false;
            
            visited.add(current);
            for(int i:neighbors.get(current)){
                if(i != prev) {
                    q.add(i);
                    prevs.add(current);
                }
            }
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
