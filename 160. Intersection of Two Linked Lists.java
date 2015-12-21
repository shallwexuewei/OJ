/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode node = headA;
        while(node != null) {
            sizeA++;
            node = node.next;
        }
        node = headB;
        while(node != null) {
            sizeB++;
            node = node.next;
        }
        
        if(sizeA > sizeB) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
            
            int t = sizeA;
            sizeA = sizeB;
            sizeB = t;
        }
        
        // headA is shorter
        int diff = sizeB - sizeA;
        ListNode nodeB = headB;
        for(int i = 0; i < diff; i++) {
            nodeB = nodeB.next;
        }
        node = headA;
        while(node != null && nodeB != null && node != nodåeB) {
            node = node.next;
            nodeB = nodeB.next;
        }
        if(node == null) {
            return null;
        } else {
            return node;
        }
    }
}
