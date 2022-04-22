class MyHashMap {
    
    int capacity;
    int size;
    TreeSet<Node> [] map;

    public MyHashMap() {
        this.capacity=16;
        this.size=0;
        this.map=new TreeSet[this.capacity];

        for(int i=0;i<this.capacity;i++)
            this.map[i]=new TreeSet<>((a,b)->Integer.compare(a.key,b.key));
    }
    
    public void put(int key, int value) {
        int idx=getHash(key,this.capacity);
        Node curr=new Node(key,value);
        if(map[idx].contains(curr)){
            map[idx].remove(curr);
            map[idx].add(curr);
            return;
        }
        this.size++;
        map[idx].add(curr);
        if(this.size==this.capacity)
            doubleCapacity();
    }
    private void doubleCapacity(){
        int newCapacity=this.capacity*2;
        TreeSet<Node> [] newMap=new TreeSet[newCapacity];

        for(int i=0;i<newCapacity;i++)
            newMap[i]=new TreeSet<>((a,b)->Integer.compare(a.key,b.key));

        for(TreeSet<Node> ts:this.map)
            for(Node e:ts){
                int idx=getHash(e.key,newCapacity);
                newMap[idx].add(e);
            }

        this.map=newMap;
        this.capacity=newCapacity;
    }
    public int get(int key) {
        
        int idx=getHash(key,this.capacity);
        Node temp=new Node(key,-1);
        temp=this.map[idx].floor(temp);
        
        return temp!=null&&temp.key==key?temp.val:-1;
    }
    
    public void remove(int key) {
        int idx=getHash(key,this.capacity);
        Node temp=new Node(key,0);
        if(this.map[idx].remove(temp))
            this.size--;
    }
    
    private int getHash(int key,int capacity){
        return key%capacity;
    }
}

class Node{

    int key;
    int val;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */