class MyHashSet {
    
    class Node {
            int val;
            Node next;

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
    }
    
    Node[] bucket;
    int size = 1000;
    
    public MyHashSet() {
        bucket = new Node[size];
    }
    
    public void add(int key) {
        Node node = bucket[key % size];
        
        if (node == null) {
                bucket[key % size] = new Node(key, null);
                return;
          }
        Node prev = null;
            while (node != null) {
                if (node.val == key)
                    return;
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, null);
    }
    
    public void remove(int key) {
        Node node = bucket[key % size];
            if (node == null)
                return;
            Node prev = null;
            while (node != null) {
                if (node.val == key) {
                    if (prev == null) {
                        bucket[key % size] = node.next;
                    } else {
                        prev.next = node.next;
                    }
                    return;
                }
                prev = node;
                node = node.next;
            }
    }
    
    public boolean contains(int key) {
         Node curr = bucket[key % size];
            if (curr == null) {
                return false;
            }
            while (curr != null) {
                if (curr.val == key)
                    return true;
                curr = curr.next;
            }
            return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */