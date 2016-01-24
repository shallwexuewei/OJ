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
        if(root == null) {
            // throw new ...
        }
        return closestValue(root, target, Double.MAX_VALUE, 0);
    }
    
    private int closestValue(TreeNode node, double target, double minDiff, int closest) {
        if(node == null)    return closest;
        
        if(node.val == target) {
            return node.val;
        } else if(node.val < target) {
            if(minDiff > target - node.val) {
                closest = node.val;
                minDiff = target - node.val;
            }
            
            return closestValue(node.right, target, minDiff, closest);
        } else {
            if(minDiff > node.val - target) {
                closest = node.val;
                minDiff = node.val - target;
            }
            return closestValue(node.left, target, minDiff, closest);
        }
    }
}
