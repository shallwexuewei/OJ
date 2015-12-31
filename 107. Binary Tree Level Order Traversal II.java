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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null)    return res;
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int num = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < num; i++) {
                TreeNode node = q.removeFirst();
                if(node.left != null)   q.add(node.left);
                if(node.right != null)  q.add(node.right);
                list.add(node.val);
            }
            if(!list.isEmpty()) res.add(0, list);
        }
        return res;
    }
}
