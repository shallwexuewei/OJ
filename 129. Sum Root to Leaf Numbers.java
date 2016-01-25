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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)   return 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        sumNumbers(root, list);
        return sum;
        
    }
    
    private void sumNumbers(TreeNode node, ArrayList<Integer> list) {
        if(node.left == null && node.right == null) {
            int num = node.val;
            int size = list.size();
            int times = 10;
            for(int i = size - 1; i > -1; i--) {
                num += times*list.get(i);
                times *= 10;
            }
            sum += num;
            return ;
        }
        
        list.add(node.val);
        
        if(node.left != null)   sumNumbers(node.left, list);
        if(node.right != null)  sumNumbers(node.right, list);
        
        list.remove(list.size()-1);
    }
}
