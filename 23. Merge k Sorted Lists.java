/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;
        
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if(lo == hi) {
            return lists[lo];
        }
        
        int mid = lo + (hi - lo)/2;
        ListNode list1 = merge(lists, lo, mid);
        ListNode list2 = merge(lists, mid + 1, hi);
        
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if(list1 != null) {
            prev.next = list1;
        } else {
            prev.next = list2;
        }
        return fakeHead.next;
    }
}

/*
Submission Result: Wrong Answer More Details 

Input:
[[0,2,5]]
Output:
[5]
Expected:
[0,2,5]
*/
