public class Solution {
    public class Node{
        private char c;
        private HashSet<Node> prevs;
        public HashSet<Node> nexts;
        public Node(char c) {
            this.c = c;
            this.prevs = new HashSet<Node>();
            this.nexts = new HashSet<Node>();
        }
        public void addNext(Node next) {
            this.nexts.add(next);
            next.addPrev(this);
        }
        private void addPrev(Node prev) {
            this.prevs.add(prev);
        }
        public int prevSize() {
            return prevs.size();
        }
        public char getC() {
            return c;
        }
        public HashSet<Node> release() {
            for(Node n:nexts) {
                n.removePrev(this);
            }
            return nexts;
        }
        public void removePrev(Node prev){
            prevs.remove(prev);
        }
    }
    
    public String alienOrder(String[] words) {
        
        int len = words.length;
        if(len < 1) {
            throw new IllegalArgumentException();
        }
        if(len == 1) {
            return words[0];
        }
        
        String prev = words[0]; 
        HashMap<Character, Node> char2node = new HashMap<Character, Node>();
        for(int i = 1; i < len; i++) {
            String current = words[i];
            int j = 0;
            while(j < prev.length() && j < current.length() && prev.charAt(j) == current.charAt(j)) {
                if(char2node.containsKey(prev.charAt(j)) == false) char2node.put(prev.charAt(j), new Node(prev.charAt(j)));
                j++;
            }
            
         
             
            if(j != prev.length() && j != current.length()) {
                char p = prev.charAt(j);
                char c = current.charAt(j);
                if(!char2node.containsKey(p)){ 
                    char2node.put(p, new Node(p));
                }
                if(!char2node.containsKey(c)){ 
                    char2node.put(c, new Node(c));
                }
                char2node.get(p).addNext(char2node.get(c));
            } 
            
            for(int k = j + 1; k < prev.length(); k++) {
                char c = prev.charAt(k);
                if(!char2node.containsKey(c)) {
                    char2node.put(c, new Node(c));
                }
            }
            for(int k = j + 1; k < current.length(); k++) {
                char c = current.charAt(k);
                if(!char2node.containsKey(c)) {
                    char2node.put(c, new Node(c));
                }
            }
            prev = current;
        }
        
        StringBuilder builder = new StringBuilder();
        Node head = null;
        LinkedList<Node> q = new LinkedList<Node>();
        for(Character c:char2node.keySet()){
            if(char2node.get(c).prevSize() == 0){
                q.add(char2node.get(c));
            }
        }
        
        while(!q.isEmpty()){
            Node node = q.removeLast();
            builder.append(node.getC());
            HashSet<Node> nexts = node.release();
            for(Node n:nexts) {
                if(n.prevSize() == 0){
                    q.add(n);
                }
            }
        }
        
        
        for(Character c:char2node.keySet()){
            if(char2node.get(c).prevSize() != 0){
                return "";
            }
        }
        
        return builder.toString();
        
        
    }
}

/*
["z", "z"]

Runtime Error Message:
Line 50: java.lang.StringIndexOutOfBoundsException: String index out of range: 1
Last executed input:
["tacfeiea","t","ugwchsual","gt","ozlqu","urvmv","pfuem","dcrg","mhz","fi","hv","wekpblyp","cjby","xfnlff"]

Input:
["za","zb","ca","cb"]
Output:
"zcabb"
Expected:
Special judge: No expected output available.
so, changes to hashset

Input:
["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"]
Output:
"zhywvutsrxqnmligcba"
Expected:
""
so detect cycle
*/
