/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)    return null;
        
        LinkedList<RandomListNode> q = new LinkedList<RandomListNode>();
        HashMap<RandomListNode, RandomListNode> node2node = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode head2 = new RandomListNode(head.label);
        node2node.put(head, head2);
        q.add(head);
        
        while(!q.isEmpty()){
            RandomListNode cur = q.removeFirst();
            RandomListNode cur2 = node2node.get(cur);
            
            if(cur.next != null) {
                RandomListNode next = cur.next;
                if(node2node.containsKey(next)){
                    cur2.next = node2node.get(next);
                } else {
                    RandomListNode next2 = new RandomListNode(next.label);
                    node2node.put(next, next2);
                    cur2.next = next2;
                    q.add(next);
                }
            } 
            if(cur.random != null) {
                RandomListNode r = cur.random;
                if(node2node.containsKey(r)){
                    cur2.random = node2node.get(r);
                } else {
                    RandomListNode r2 = new RandomListNode(r.label);
                    node2node.put(r, r2);
                    cur2.random = r2;
                    q.add(r);
                }
            }
        }
        
        return head2;
    }
}
