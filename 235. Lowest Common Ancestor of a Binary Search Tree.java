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
        while(true) {
            if(root == p || root == q)  break;
            
            boolean leftP = find(root.left, p);
            boolean leftQ = find(root.left, q);
            if(leftP != leftQ) {
                break;
            }
            if(leftP) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
    
    private boolean find(TreeNode node, TreeNode p) {
        if(node == null)    return false;
        
        if(node == p)       return true;
        if(node.left != null) {
            if(find(node.left, p)) {
                return true;
            }
        }
        if(node.right != null) {
            if(find(node.right, p)) {
                return true;
            }
        }
        return false;
    }
}
