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
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root == null)    return 0;
        
        calSum(root);
        return maxSum;
    }
    
    private int calSum(TreeNode node) {
        if(node.left == null && node.right == null) {
            if(node.val > maxSum)   maxSum = node.val;
            return node.val;
        }
        
        int leftSum = 0;
        if(node.left != null) {
            leftSum = Math.max(0, calSum(node.left));
        }
        int rightSum = 0;
        if(node.right != null) {
            rightSum = Math.max(0, calSum(node.right));
        }
        int curSum = node.val + leftSum + rightSum;
        if(curSum > maxSum)    maxSum = curSum;
        
        return node.val + Math.max(leftSum, rightSum);
    }
}
