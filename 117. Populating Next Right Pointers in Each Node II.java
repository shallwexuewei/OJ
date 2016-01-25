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
        
        TreeLinkNode fakeHead = new TreeLinkNode(0);
        TreeLinkNode prev = fakeHead;
        while(root != null) {
            if(root.left != null) {
                prev.next = root.left;
                prev = root.left;
            }
            if(root.right != null) {
                prev.next = root.right;
                prev = root.right;
            }
            root = root.next;
        }
        
        // fakeHead.next is the real head of the next level
        connect(fakeHead.next);
    }
}
