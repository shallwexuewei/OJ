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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)    return result;
        
        Queue<Integer> cols = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> rightCols = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> leftCols = new ArrayList<ArrayList<Integer>>();
        
        queue.add(root);
        cols.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int col = cols.poll();
                TreeNode node = queue.poll();
                // left or right?
                if(col < 0) {
                    int index = -col-1;
                    if(leftCols.size() > index) {
                        leftCols.get(index).add(node.val);
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(node.val);
                        leftCols.add(list);
                    }
                } else {
                    if(rightCols.size() > col) {
                        rightCols.get(col).add(node.val);
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(node.val);
                        rightCols.add(list);
                    }
                }
                
                if(node.left != null) {
                    queue.add(node.left);
                    cols.add(col - 1);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    cols.add(col + 1);
                }
            }
        }
        
        for(int i = leftCols.size() - 1; i > -1; i--) {
            result.add(leftCols.get(i));
        }
        result.addAll(rightCols);
        return result;
    }
}
/*
Input:
[6,1,null,null,3,2,5,null,null,4]
Output:
[[2],[1],[6,3,4],[5]]
Expected:
[[1,2],[6,3,4],[5]]
*/
