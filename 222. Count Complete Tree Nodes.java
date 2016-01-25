/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)    return 0;
        
        return postorder(root);
    }
    
    private int postorder(TreeNode node) {
        if(node.left == null) {
            return 1;
        }
        
        if(node.right == null) {
            return 1 + postorder(node.left);
        } else {
            return 1 + postorder(node.left) + postorder(node.right);
        }
    }
}
