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
    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private int closestValue(TreeNode node, double target, int larger, int smaller) {
        if(node == null) {
            return larger-target < target-smaller ? larger:smaller;
        }
        
        if(target > node.val) {
            return closestValue(node.right, target, larger, node.val);
        } else {
            return closestValue(node.left, target, node.val, smaller);
        }
    }
}

/*
Input:
[1]
4.428571
Output:
-2147483648
Expected:
1
*/
