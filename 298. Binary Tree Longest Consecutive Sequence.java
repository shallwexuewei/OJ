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
    public int longestConsecutive(TreeNode root) {
        if(root == null)    return 0;
        
        int max = 1;
        if(root.left != null)   max = longestConsecutive(root.left, root.val, 1, max);
        if(root.right != null)  max = longestConsecutive(root.right, root.val, 1, max);
        return max;
    }
    
    private int longestConsecutive(TreeNode node, int parentVal, int curLen, int maxLen) {
        if(node.val == parentVal + 1) {
            curLen++;
            if(curLen > maxLen) maxLen = curLen;
        } else {
            curLen = 1;
        }
        
        if(node.left != null)   maxLen = longestConsecutive(node.left, node.val, curLen, maxLen);
        if(node.right != null)  maxLen = longestConsecutive(node.right, node.val, curLen, maxLen);
        return maxLen;
    }
}
