/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return null;
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> node2node = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        UndirectedGraphNode node2 = new UndirectedGraphNode(node.label);
        node2node.put(node, node2);
        
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.removeFirst();
            UndirectedGraphNode cur2 = node2node.get(cur);
            for(UndirectedGraphNode neighbor:cur.neighbors) {
                if(node2node.containsKey(neighbor)){
                    cur2.neighbors.add(node2node.get(neighbor));
                } else {
                    UndirectedGraphNode neighbor2 = new UndirectedGraphNode(neighbor.label);
                    node2node.put(neighbor, neighbor2);
                    cur2.neighbors.add(neighbor2);
                    q.add(neighbor);
                }
            }
        }
        
        return node2;
    }
}
