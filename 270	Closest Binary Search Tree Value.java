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
        return closestValue(root, target, Integer.MAX_VALUE, Integer.MIN_VALUE, false, false);
    }
    
    private int closestValue(TreeNode node, double target, int larger, int smaller, boolean largeC, boolean smallC) {
        if(node == null) { 
            if(!smallC)
                return larger;
            if(!largeC)
                return smaller;
            return larger-target < target-smaller ? larger:smaller;
        }
        
        if(target > node.val) {
            return closestValue(node.right, target, larger, node.val, largeC, true);
        } else {
            return closestValue(node.left, target, node.val, smaller, true, smallC);
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
