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
        if(root == null) {
            return;
        }
        
        rightmost(root); 
    }
    
    public TreeNode rightmost(TreeNode node) { 
        if(node.left == null && node.right == null) { 
            return node;
        } 
        
        // inorder  
        if(node.left == null) {
            return rightmost(node.right);
        } else { 
            TreeNode right = node.right;
            node.right = node.left;
            TreeNode prev = rightmost(node.left);  
            node.left = null;
            prev.right = right;  
            return rightmost(node.right);
        }
        
    } 
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2]
Output:
[1,2]
Expected:
[1,null,2]
*/
