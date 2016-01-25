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
        if(root == null)    return;
        
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode prev = null;
            for(int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if(node.left != null) {
                    if(prev != null) {
                        prev.next = node.left; 
                    }
                    prev = node.left;
                    queue.add(node.left);
                }
                if(node.right != null) {
                    if(prev != null) {
                        prev.next = node.right; 
                    }
                    prev = node.right;
                    queue.add(node.right);
                }
            }
        }
    }
}
