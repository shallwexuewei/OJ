/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        if(head == null) {
            return true;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.add(slow);
            slow = slow.next;
        }
        
        // odd list, e.g. 1 2 3
        // even list, e.g. 1 2 3 4
        if(fast !=  null) {
            slow = slow.next;
        }
        
        while(stack.isEmpty() == false) {
            if(slow.val != stack.removeLast().val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
/*
 Wrong Answer More Details 

Input:
[1,0,0]
Output:
true
Expected:
false

 Wrong Answer More Details 

Input:
[1,2]
Output:
true
Expected:
false
*/
