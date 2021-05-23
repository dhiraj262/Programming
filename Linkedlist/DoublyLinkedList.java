

class NodeDll {
     int data;
     NodeDll prev;
     NodeDll next;

     NodeDll(int data){
         this.data = data;
         this.prev=null;
         this.next=null;
     }
}

public class DoublyLinkedList {
    NodeDll head = null;

    //O(1)
    public void insertBeg(int data){
        NodeDll newNode = new NodeDll(data);

        if(head==null){
             head=newNode;
             return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //O(n)
    public void insertEnd(int data){
        NodeDll newNode = new NodeDll(data);
        if(head==null){
            head = newNode;
            return;
        }

        NodeDll p = head;
        while(p.next!=null){
            p=p.next;
        }
        p.next = newNode;
        newNode.prev = p;
    }
    //O(n)
    public void insertMid(int num,int data){
        NodeDll newNode = new NodeDll(data);
        NodeDll p =head;
        while(p!=null && p.data!=num){
            p=p.next;
        }
        newNode.next = p.next;
        if(p.next!=null)
        p.next.prev = newNode;
        p.next = newNode;
        newNode.prev=p;
    }
    //O(n)
    public void delete(int num){
        if(head==null) return;
        NodeDll p  = head;
        while(p!=null && p.data!=num){
            p=p.next;
        }
        if(p==head){
            head = head.next;
            head.prev=null;
            return;
        }
        p.prev.next = p.next;
        if(p.next!=null) p.next.prev = p.prev;
       
    }

    public void display(){
        NodeDll p = head;
        while(p!=null){
            System.out.println(p.data);
            p=p.next;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertBeg(2);
        dll.insertBeg(1);
        dll.display();
        System.out.println("\n");
        dll.insertEnd(3);
        dll.insertEnd(5);
        dll.insertEnd(1);
        dll.insertMid(3, 8);
        dll.insertEnd(4);
        dll.delete(1);
        dll.delete(4);
        dll.display();
    }
}
