/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int i;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        buildStr(root, res); 
        res.setLength(res.length()-1);
        return res.toString();
    }
    
    private void buildStr(TreeNode node, StringBuilder builder) {
        if(node == null) {
            builder.append("null,");
            return;
        }
        
        builder.append(node.val);
        builder.append(',');
        buildStr(node.left, builder);
        buildStr(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int len = strs.length;
        if(len == 0) {
            return null;
        } 
        i = -1;
        return buildTree(strs);
    }
    
    private TreeNode buildTree(String[] strs) {
        i++;
        if(strs[i].equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(strs[i]));
        node.left = buildTree(strs);
        node.right = buildTree(strs);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
