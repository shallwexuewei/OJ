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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)    return result;
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        findPaths(root, sum, stack, result);
        return result;
    }
    
    private void findPaths(TreeNode node, int sum, LinkedList<Integer> stack, List<List<Integer>> result) {
        
        
        int rest = sum - node.val;
        if(node.left == null && node.right == null) {
            if(rest == 0) {
                ArrayList list = new ArrayList();
                list.addAll(stack);
                list.add(node.val);
                result.add(list);
            } 
            return;
        }
        
        stack.add(node.val);
        
        if(node.left != null) {
            findPaths(node.left, rest, stack, result);
        }
        if(node.right != null) {
            findPaths(node.right, rest, stack, result);
        }
        
        stack.removeLast();
    }
}
