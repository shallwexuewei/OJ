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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)    return res;
        
        LinkedList<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            TreeNode node = null;
            for(int i = 0; i < n; i++) {
                node = q.removeFirst();
                if(node.left != null)   q.add(node.left);
                if(node.right != null)  q.add(node.right);
            }
            res.add(node.val);
        }
        
        return res;
    }
}
