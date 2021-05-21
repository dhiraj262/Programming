
// Node class to represent the data and next which is used as an object to create linked list.
class Node{
    Integer data;
    Node next;

    Node(int data){
        this.data = data;
        this.next=null;
    }

}
public class LinkedList {
    Node head=null;

    public void insertBeg(int data){
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }else {
            Node p = head;
            while(p.next!=null){
                p=p.next;
            }
            p.next = newNode;
        }
    }

    public void insert(int num,int data){
        Node p =head;
        while(p!=null && p.data!=num){
            p=p.next;
        }

        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;   
    }

    public int remove(int num){

        if(head==null) return -1;
        Node p =head;
        Node prev = null;
        while(p.data!=num){
            prev = p;
            p = p.next;
        }
        //deleting first element
        if(p==head){
            head = head.next;
            return p.data;
        } 
            
        prev.next = p.next;
        return p.data;
        
    }

    void display(){
        Node p = head;
        while(p!=null){
            System.out.println(p.data);
            p=p.next;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertBeg(5);
        ll.insertBeg(56);
        ll.insertEnd(88);
        ll.insertEnd(22);
        ll.insertEnd(10);
        ll.insert(22, 44);
        ll.insert(5, 77);
        ll.display();
        ll.remove(56);
        ll.remove(22);
        ll.remove(10);
        System.out.println("after romove");
        ll.display();
    }
}
