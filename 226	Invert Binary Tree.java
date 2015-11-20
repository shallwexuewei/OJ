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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }
}

/*
Wrong Answer More Details 

Input:
[4,2,7,1,3,6,9]
Output:
[4,7,2,6,9,1,3]
Expected:
[4,7,2,9,6,3,1]
*/
