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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null)    return result;
        
        StringBuilder builder = new StringBuilder();
        buildPath(root, result, builder);
        return result;
    }
    
    private void buildPath(TreeNode node, List<String> result, StringBuilder builder) {
        int oldLen = builder.length();
        
        if( (node.left == null) && (node.right == null)) {
            builder.append(node.val);
            result.add(builder.toString());
            builder.setLength(oldLen);
            return;
        }
        
        builder.append(node.val);
        builder.append("->");
        
        if(node.left != null)   buildPath(node.left, result, builder);
        if(node.right != null)  buildPath(node.right, result, builder);
        
        builder.setLength(oldLen);
    }
}
