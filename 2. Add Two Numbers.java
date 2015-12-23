/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int c = 0;
        ListNode prev = null;
        ListNode node = null;
        ListNode head = null;
        while(n1 != null || n2 != null) {
            int tmp = c;
            if(n1 != null) {
                tmp += n1.val;
                n1 = n1.next;
            }
            if(n2 != null) {
                tmp += n2.val;
                n2 = n2.next;
            }
            
            if(tmp > 9) {
                tmp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            
             node = new ListNode(tmp);
            if(prev != null) {
                prev.next = node;
            } else {
                head = node;
            }
            prev = node; 
        } 
        if(c == 1) {
            node = new ListNode(c);
            prev.next = node;
        }
        return head;
    }
}

/*
Submission Result: Time Limit Exceeded More Details 

Last executed input:
[7,0,3,6,7,3,2,1,5]
[9,2,5,5,6,1,2,2,4]
*/
