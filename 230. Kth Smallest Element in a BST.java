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
    private boolean found = false;
    
    public int kthSmallest(TreeNode root, int k) {
        int leftSize = 0;
        if(root.left != null) {
            leftSize = kthSmallest(root.left, k);
            if(found) {
                return leftSize;
            }
        }
        k -= leftSize;
        if(k == 1) {
            found = true;
            return root.val;
        }
        int rightSize = 0;
        k--;
        if(root.right != null) {
            rightSize = kthSmallest(root.right, k);
            if(found) {
                return rightSize;
            }
        }
        k -= rightSize;
        return leftSize + 1 + rightSize;
    }
}
