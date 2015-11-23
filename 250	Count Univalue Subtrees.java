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
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] cnt = new int[1];
        cnt[0] = 0;
        count(root, cnt);
        return cnt[0];
    }
    
    private boolean count(TreeNode node, int[] cnt) {
        if(node.left == null && node.right == null) {
            cnt[0]++;
            return true;
        } else if(node.left == null) {
            if(count(node.right, cnt)){
                if(node.right.val == node.val) {
                    cnt[0]++;
                    return true;
                }
            }
            return false;
        } else if(node.right == null) {
            if(count(node.left, cnt)){
                if(node.left.val == node.val) {
                    cnt[0]++;
                    return true;
                }
            }
            return false;
        } else {
            boolean result = count(node.left, cnt);
            result = result & count(node.right, cnt);
            if( result ){
                if(node.left.val == node.val && node.val == node.right.val) {
                    cnt[0]++;
                    return true;
                }
            } 
            return false;
        }
    }
}

/*
Wrong Answer More Details 

Input:
[5,5,5,5,5,null,5]
Output:
3
Expected:
6

 Wrong Answer More Details 

Input:
[5,1,5,5,5,null,5]
Output:
2
Expected:
4
*/
