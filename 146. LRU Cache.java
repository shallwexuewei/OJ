public class LRUCache {
    private Node head;
    private Node tail;
    private int size;
    private int capacity;
    private HashMap<Integer, Node> key2node;
    
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node() {
            
        }
        
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
        key2node = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    
    
    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
        
        size++;
    }
    
    public Node getNode(int key) { 
        if(key2node.containsKey(key)){
            Node node = key2node.get(key);
            
            remove(node);
            insert(node);
            return node;
        } 
        return null;
    }
    
    public int get(int key) {
        Node node = getNode(key);
        if(node == null) {
            return -1;
        }
        return node.val;
    }
     
    public void set(int key, int value) {
        if(key2node.containsKey(key)){
            Node node = getNode(key);
            node.val = value;
            
            remove(node);
            insert(node);
        } else {
            Node node = new Node(key, value);
            if(size < capacity) { 
                insert(node);
            } else {
                key2node.remove(tail.prev.key);
                remove(tail.prev);
                insert(node);
            }
            key2node.put(key, node);
        }
    }
}

/*
Runtime Error More Details 

Runtime Error Message:
Line 87: java.lang.NullPointerException
Last executed input:
2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
*/
