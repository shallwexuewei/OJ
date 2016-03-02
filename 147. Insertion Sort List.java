/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        
        ListNode node = head;
        while(node != null) {
            System.out.println(node.val);
            while ( node.next != null && node.next.val >= node.val) {
                node = node.next;
            }
            
            if(node.next == null) {
                break;
            }
            
            ListNode insertedNode = node.next;
			// delete it from the original position
			node.next = node.next.next;
			
            if(insertedNode.val < head.val) {
                insertedNode.next = head;
                head = insertedNode;
            } else {
                ListNode prevNode = head;
                while(insertedNode.val > prevNode.next.val) {
                    prevNode = prevNode.next;
                }
                insertedNode.next = prevNode.next;
                prevNode.next = insertedNode;
            }
            
            node = insertedNode;
        }
        
        return head;
    }
}

/*
Submission Result: Time Limit Exceeded More Details 

Last executed input:
[1,1]
*/
