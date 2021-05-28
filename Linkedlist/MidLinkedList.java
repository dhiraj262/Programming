/*Finding the mid element in linkedlist.*/

public class MidLinkedList {

    public static int mid(LinkedList ll){
        Node slow = ll.head;
        Node fast = ll.head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        LinkedList ll  = new LinkedList();
        ll.insertBeg(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);
        ll.insertEnd(5);
        ll.insertEnd(6);
        ll.insertEnd(7);
    
        System.out.println(" Mid elemnt in the linked list is : "+mid(ll));

    }
}

