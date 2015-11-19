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
        if(root == null) {
            return 0;
        }
        
        // DFS
        return longestConsecutive(root, root.val, 0);
    }
    
    private int longestConsecutive(TreeNode node, int first, int max) {
        if(node.right == null && node.left == null) {
            max = Math.max(max, node.val - first + 1);
            return max;
        }
        if(node.right != null) {
            if(node.right.val == node.val + 1) {
                max = Math.max(max, longestConsecutive(node.right, first, max));
            } else {
                max = Math.max(max, node.val - first + 1);
                max = Math.max(max, longestConsecutive(node.right, node.right.val, max));
            }
        } 
        if(node.left != null) {
            if(node.left.val == node.val + 1) {
                max = Math.max(max, longestConsecutive(node.left, first, max));
            } else {
                max = Math.max(max, node.val - first + 1);
                max = Math.max(max, longestConsecutive(node.left, node.left.val, max));
            }
        }
        return max;
    }
}
