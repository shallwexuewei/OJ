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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)    return res;
        
        // use queue to store nodes
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        // use a bool var to indicate order
        boolean fromRight = false;
        
        while(!q.isEmpty()){
            // use q.size() to get the number of nodes of last level
            int num = q.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i = 0; i < num; i++) {
                TreeNode node = q.removeFirst();
                if(node.left != null)   q.add(node.left);
                if(node.right != null)  q.add(node.right);
                if(fromRight)           list.add(0, node.val);
                else                    list.add(node.val);
            }
            if(!list.isEmpty()){
                res.add(list);
            }
            fromRight = !fromRight;
        }
        return res;
        
    }
}
