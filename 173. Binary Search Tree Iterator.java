/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        if(root == null)    return ;
        
        stack = new Stack<TreeNode>();
        cur = findSmallest(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }
    
    private TreeNode findSmallest(TreeNode node) {
        while(node.left != null) {
            stack.add(node);
            node = node.left;
        }
        return node;
    }

    /** @return the next smallest number */
    public int next() {
        int val = cur.val;
        if(cur.right != null) {
            cur = findSmallest(cur.right);
        } else if(!stack.isEmpty()) {
            cur = stack.pop();
        } else {
            cur = null;
        }
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
