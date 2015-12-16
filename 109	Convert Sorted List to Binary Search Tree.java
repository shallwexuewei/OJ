/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) { 
        int len = 0;
        
        current = head;
        
        while(head != null) {
            len += 1;
            head = head.next;
        }
        
        if(len == 0) {
            return null;
        }
        
        return buildTree(len);
    }
    
    private TreeNode buildTree(int n) {
        if(n < 1) {
            return null;
        }
        
        int half = n/2;
        TreeNode node = new TreeNode(0);
        node.left = buildTree(half); 
        node.val = current.val;
        current = current.next; 
        node.right = buildTree(n - half - 1); 

        return node;
    }
}
