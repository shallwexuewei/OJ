/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        LinkedList<Integer> depths = new LinkedList<Integer>();
        q.add(root);
        depths.add(0);
        TreeLinkNode prev = null;
        int prevD = -1;
        while(!q.isEmpty()){
            TreeLinkNode node = q.removeFirst();
            int d = depths.removeFirst();
            if(prev == null) {
                
            } else {
                if (prevD == d) {
                    prev.next = node;
                } else {
                    prev.next = null;
                }
            }
            if(node.left != null) {
                q.add(node.left);
                depths.add(d+1);
            } 
            if(node.right != null) {
                q.add(node.right);
                depths.add(d+1);
            }
            prevD = d;
            prev = node;
        }
        if(prev != null) {
            prev.next = null;
        }
    }
}
