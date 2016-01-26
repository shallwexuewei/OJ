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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        
        TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFound = lowestCommonAncestor(root.right, p, q);
        
        if(leftFound != null && rightFound != null)     return root;
        else if(leftFound != null)                      return leftFound;
        else if(rightFound != null)                     return rightFound;
        else                                            return null;
    }
}
