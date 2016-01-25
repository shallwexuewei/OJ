/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        
        
        root.next = null;
        TreeLinkNode next = root;
        while(next.left != null) {
            TreeLinkNode cur = next;
            next = cur.left;
            
            cur.left.next = cur.right;
            TreeLinkNode prev = cur;
            cur = cur.next;
            while(cur != null) {
                prev.right.next = cur.left;
                cur.left.next = cur.right;
                prev = cur;
                cur = cur.next;
            }
            prev.right.next = null;
        }
        
    }
}

/*
Submission Result: Runtime Error More Details 

Runtime Error Message:
Line 27: java.lang.NullPointerException
Last executed input:
{1,2,3}

Submission Result: Time Limit Exceeded More Details 

Last executed input:
{0,1,2,3,4,5,6}
*/
