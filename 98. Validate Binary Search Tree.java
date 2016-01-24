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
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if(node.val <= min || node.val >= max) {
            return false;
        }
        
        if(node.left != null) {
            if(isValidBST(node.left, min, node.val) == false){
                return false;
            }
        }
        if(node.right != null) {
            if(isValidBST(node.right, node.val, max) == false){
                return false;
            }
        }
        return true;
    }
}
