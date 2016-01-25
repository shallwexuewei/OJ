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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)   return 0;
        
        sumNumbers(root, 0);
        return sum;
        
    }
    
    private void sumNumbers(TreeNode node, int preNum) {
        int num = preNum*10 + node.val;
        
        if(node.left == null && node.right == null) {
            sum += num;
            return ;
        }
        
        if(node.left != null)   sumNumbers(node.left, num);
        if(node.right != null)  sumNumbers(node.right, num);
        
    }
}
