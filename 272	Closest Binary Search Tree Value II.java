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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // Given a non-empty binary search tree 
        ArrayList<Integer> all = new ArrayList<Integer>();
        inorder(root, all);
        
        // binary search
        int low = 0;
        int high = all.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(target > all.get(mid)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        List<Integer> result = new LinkedList<Integer>();
        int i = high; // left of target
        int j = low; // right of target
        int last = -1;
        while(result.size() < k && i > -1 && j < all.size()){
            if(target - all.get(i) < all.get(j) - target){
                result.add(all.get(i));
                i--;
            } else {
                result.add(all.get(j));
                j++;
            }
        }
        
        if(result.size() < k) {
            if(i == -1) {
                while(result.size() < k && j < all.size()) {
                    result.add(all.get(j));
                    j++;
                }
            } else {
                while(result.size() < k && i > -1) {
                    result.add(all.get(i));
                    i--;
                }
            }
        }
        return result;
    }
    
    private void inorder(TreeNode node, ArrayList<Integer> all) {
        if(node.left != null) inorder(node.left, all);
        all.add(node.val);
        if(node.right != null) inorder(node.right, all);
    }
}

/*
Input:
[3,2,4,1]
2.000000
3
Output:
[2,1]
Expected:
[2,1,3]
*/
