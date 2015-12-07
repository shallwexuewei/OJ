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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        
        if(root == null) {
            return res;
        }
        
        pathSum(root, sum, path, res);
        return res;
        
    }
    
    private void pathSum(TreeNode node, int rest, LinkedList<Integer> path, List<List<Integer>> res) {
        
        path.add(node.val);
        // base case
        if(node.left == null && node.right == null) {
            if(node.val == rest) { 
                res.add(new LinkedList<Integer>(path));
            }
            path.removeLast();
            return;
        }
        if(node.left != null) {
            pathSum(node.left, rest-node.val, path, res);
        }
        if(node.right != null) {
            pathSum(node.right, rest-node.val, path, res);
        }
        path.removeLast();
    }
}

/*
Line 30: error: List is abstract; cannot be instantiated
*/
