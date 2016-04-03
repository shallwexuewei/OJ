import java.util.HashMap;

public class Solution {
    class ListNode {
        char ch;
        int lastPos;
        ListNode next;
        ListNode prev;
        
        public ListNode() {}
        public ListNode(int i, char c) {
            lastPos = i;
            ch = c;
        }
    }
    
    ListNode head;
    ListNode tail;
    int maxLen;
    HashMap<Character, ListNode> char2node;
    int left;
    
    public Solution() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        char2node = new HashMap<Character, ListNode>();
        maxLen = 0;
        left = 0;
    }
    
    private void delete(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void putTail(ListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        
        tail.prev.next = node;
        tail.prev = node;
    }
    
    public void insert(int idx, char ch, int k) {
        if(char2node.containsKey(ch)) {
            // delete and put tail
            ListNode node = char2node.get(ch);
            node.lastPos = idx;
            if(node != tail.prev) {
                delete(node);
                putTail(node);
            }
        } else {
            ListNode node = new ListNode(idx, ch);
            if(char2node.size() >= k) {
                left = head.next.lastPos + 1;
                char2node.remove(head.next.ch);
                delete(head.next);
            }
            // put tail
            putTail(node);
            char2node.put(ch, node);
        }
        updateWindow(idx);
    }
    
    private void updateWindow(int right) {
        if(maxLen < right - left + 1) {
            maxLen = right - left + 1;
        }
    }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || k < 1) {
            return 0;
        }
        
        for(int i = 0; i < s.length(); i++) {
            insert(i, s.charAt(i), k);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
    	Solution so = new Solution();
    	System.out.println(so.lengthOfLongestSubstringKDistinct("bacc", 2));
    }
}
