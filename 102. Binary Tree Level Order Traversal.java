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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return res;
        }
        
        q.add(root);
    
        while(!q.isEmpty()){
            int num = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < num; i++) {
                TreeNode node = q.removeFirst();
                if(node.left != null)   q.add(node.left);
                if(node.right != null)  q.add(node.right);
                list.add(node.val);
            } 
            if(!list.isEmpty()){
                res.add(list);
            }
        }
        return res;
    }
}
