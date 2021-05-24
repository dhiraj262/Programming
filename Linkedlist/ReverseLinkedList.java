

public class ReverseLinkedList {
    
    public static void reverseList(LinkedList ll){
        Node current = ll.head;
        Node prevNode = null;
        Node nextNode = null;
        while(current!=null){
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        // Printing the reverse of the list.
        System.out.println("\nreverse");
        while(prevNode!=null){
            System.out.println(prevNode.data);
            prevNode = prevNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertBeg(1);
        ll.insertEnd(2);
        ll.insertEnd(5);
        ll.insert(2, 3);
        ll.insert(3,4);
        ll.display();
        reverseList(ll);
    }
}
