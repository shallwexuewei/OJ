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
    public void flatten(TreeNode root) {
        if(root == null)    return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left != null) {
            TreeNode leftLast = root.left;
            while(leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
     }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2,null,3]
Output:
[1,null,2]
Expected:
[1,null,2,null,3]

Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 18: java.lang.NullPointerException
Last executed input:
[1,2]
*/
