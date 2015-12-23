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
        LinkedList<Integer> n1 = new LinkedList<Integer>();
        LinkedList<Integer> n2 = new LinkedList<Integer>();
        
        ListNode node = l1;
        while(node != null) {
            n1.add(node.val);
            node = node.next;
        }
        
        node = l2;
        while(node != null) {
            n2.add(node.val);
            node = node.next;
        }
        
        if(n1.size() > n2.size()){
            LinkedList<Integer> tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        
        // n1.size() <= n2.size() now
        int c = 0;
        ListNode prev = null;
        node = null;
        
        while(n2.isEmpty() == false) {
            int tmp = n2.removeLast() + c;
            if(!n1.isEmpty()){
                tmp += n1.removeLast();
            }
            if(tmp > 9) {
                tmp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            node = new ListNode(tmp);
            node.next = prev;
            prev = node; 
        }
        
        if(c == 1) {
            node = new ListNode(1);
            node.next = prev;
        }
        
        return node;
    }
}

/*
Submission Result: Time Limit Exceeded More Details 

Last executed input:
[7,0,3,6,7,3,2,1,5]
[9,2,5,5,6,1,2,2,4]
*/
