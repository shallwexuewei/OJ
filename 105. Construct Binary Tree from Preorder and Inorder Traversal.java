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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0 || inorder.length != len)   return null;
        
        return buildTree(preorder, 0, len-1, inorder, 0, len-1);
    }
    
    private TreeNode buildTree(int[] preorder, int preLo, int preHi, 
                                int[] inorder, int inLo, int inHi) {
        if(preLo == preHi)  return new TreeNode(preorder[preLo]);
        
        int rootVal = preorder[preLo];
        TreeNode root = new TreeNode(rootVal);
        
        int inRootIndex = inLo;
        while(inRootIndex <= inHi) {
            if(inorder[inRootIndex] == rootVal) {
                break;
            }
            inRootIndex++;
        }
        
        int leftSize = inRootIndex - inLo;
        int rightSize = inHi - inRootIndex;
        
        if(leftSize != 0) {
            root.left = buildTree(preorder, preLo + 1, preLo + leftSize, 
                                    inorder, inLo, inRootIndex-1);
        }
        if(rightSize != 0) {
            root.right = buildTree(preorder, preLo + leftSize + 1, preHi, 
                                    inorder, inRootIndex+1, inHi);
        }
        return root;
    }
}
