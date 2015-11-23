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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        
        TreeNode prev = root;
        TreeNode sibling = root.right;
        TreeNode current = root.left;
        prev.left = null;
        prev.right = null;
        while(current != null) {
            TreeNode left = current.left;
            TreeNode right = current.right; 
            
            current.left = sibling;
            current.right = prev; 
            
            prev = current;
            current = left;
            sibling = right;
        }
        return prev;
    }
}

/*
Memory Limit Exceeded More Details 

Last executed input:
[1,2]
*/
