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
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for(ListNode node:lists) {
            if(node == null) {
                continue;
            }
            queue.add(node);
        }
        
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            prev.next = node;
            if(node.next != null) {
                queue.add(node.next);
            }
            prev = node;
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
