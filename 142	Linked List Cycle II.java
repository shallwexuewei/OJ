/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        
        if(fast == null || fast.next == null) {
            return null;
        }
        
        // now fast and slow is K nodes away from the start of the cycle.
        ListNode slow2 = head;
        while(slow2 != slow) {
            slow2 = slow2.next;
            slow = slow.next;
        }
        return slow;
        
    }
}
