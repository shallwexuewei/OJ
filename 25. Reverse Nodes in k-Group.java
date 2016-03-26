/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode getGroupTail(ListNode groupHead, int k) {
        ListNode current = groupHead;
        for(int i = 0; i < k-1; i++) {
            if(current == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }
    
    private void reverse(ListNode groupHead, int k, ListNode nextGroup) {
        ListNode prev = nextGroup;
        ListNode current = groupHead;
        for(int i = 0; i < k; i++) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode groupTail = getGroupTail(head, k);
        if(groupTail == null)   return head;
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prevTail = fakeHead;
        
        ListNode groupHead = head;
        while(groupTail != null) {
            prevTail.next = groupTail;
            ListNode nextGroup = groupTail.next;
            reverse(groupHead, k, nextGroup);
            
            prevTail = groupHead;
            groupHead = nextGroup;
            groupTail = getGroupTail(groupHead, k);
        }
        return fakeHead.next;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[1,2,3]
2
Output:
[2,1]
Expected:
[2,1,3]

Submission Result: Wrong Answer More Details 

Input:
[1,2,3,4]
2
Output:
[2,1,3]
Expected:
[2,1,4,3]
*/
