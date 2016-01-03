/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode mPrev = fakeHead;
        for(int i = 1; i < m; i++) {
            mPrev = mPrev.next;
        }
        
        // now mPrev points to the (m-1)th node
        ListNode cur = mPrev.next;
        if(cur == null) return head;
        ListNode resSubTail = cur; // resultant sub tail
        
        ListNode next = cur.next; 
        for(int i = m; i < n; i++) {
            if(next == null) {
                break;
            }
            ListNode next2 = next.next;
            next.next = cur;
            cur = next;
            next = next2;
        }
        
        if(cur != resSubTail)
            resSubTail.next = next;
        
        mPrev.next = cur;
        return fakeHead.next;
    }
}

/*

Submission Result: Wrong Answer More Details 

Input:
[3,5]
1
2
Output:
[3,5]
Expected:
[5,3]
*/
