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
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        
        int d = depth(root, 0);
        if(d == -1)         return false;
        else                return true;
    }
    
    private int depth(TreeNode node, int level) {
        // base case
        if(node == null)    return level;
        
        int left = depth(node.left, level+1);
        int right = depth(node.right, level+1);
        
        if(Math.abs(left-right) > 1)    return -1;
        else                            return Math.max(left, right);
    }
}
