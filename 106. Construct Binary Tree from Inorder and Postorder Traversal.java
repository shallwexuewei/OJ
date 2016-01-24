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
    HashMap<Integer, Integer> val2index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 0 || postorder.length != len) return null;
        
        val2index = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++) {
            val2index.put(inorder[i], i);
        }
        
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inLo, int inHi, 
                                int[] postorder, int postLo, int postHi) {
        if(inLo == inHi)    return new TreeNode(inorder[inLo]);
        
        int rootVal = postorder[postHi];
        TreeNode root = new TreeNode(rootVal);
        
        int rootInIndex = val2index.get(rootVal);
        int leftSize = rootInIndex - inLo;
        int rightSize = inHi - rootInIndex;
        
        if(leftSize != 0) {
            root.left = buildTree(inorder, inLo, rootInIndex - 1, 
                                    postorder, postLo, postLo + leftSize - 1);
        }
        if(rightSize != 0) {
            root.right = buildTree(inorder, rootInIndex + 1, inHi, 
                                    postorder, postLo + leftSize, postHi - 1);
        }
        return root;
    }
}
