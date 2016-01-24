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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len < 1) return null;
        
        return buildTree(nums, 0, len-1);
    }
    
    private TreeNode buildTree(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo)/2;
        
        int rootVal = nums[mid];
        TreeNode root = new TreeNode(rootVal);
        
        if(mid > lo) {
            root.left = buildTree(nums, lo, mid - 1);
        } 
        if(mid < hi) {
            root.right = buildTree(nums, mid + 1, hi);
        }
        
        return root;
    }
}
