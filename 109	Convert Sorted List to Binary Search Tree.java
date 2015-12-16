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
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }
        
        if(arr.size() == 0) {
            return null;
        }
        
        
        return buildTree(arr, 0, arr.size()-1);
    }
    
    private TreeNode buildTree(ArrayList<Integer> arr, int low, int high) {
        if(low > high) {
            return null;
        }
        
        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = buildTree(arr, low, mid-1);
        node.right = buildTree(arr, mid+1, high);
        
        return node;
    }
}
