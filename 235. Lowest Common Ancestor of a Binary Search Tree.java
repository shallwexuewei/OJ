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
        if(root == null)    return null;
        
        if(root.val == p.val || root.val == q.val) {
            return root;
        }   
        
        boolean leftP = (root.val > p.val);
        boolean leftQ = (root.val > q.val);
        if(leftP == leftQ) {
            if(leftP)   return lowestCommonAncestor(root.left, p, q);
            else        return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
