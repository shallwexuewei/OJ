/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null)        return;
        if(head.next == null)   return;
         
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
         
        // if size is of odd number
        if(fast != null) {
            slow = slow.next;
        }
         
        // reverse the right half of the list
        ListNode prev = null;
        ListNode cur = slow;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;
        }
        // now prev is the head of the reversed list
        
        ListNode ordered = head;
        ListNode reversed = prev;
        while(reversed != null) {
            ListNode orderedNext = ordered.next;
            ordered.next = reversed;
            ListNode reversedNext = reversed.next;
            reversed.next = orderedNext;
            ordered = orderedNext;
            reversed = reversedNext;
        }
        
        if(ordered != null) {
            ordered.next = null;
        }
         
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2]
Output:
[1]
Expected:
[1,2]
*/
