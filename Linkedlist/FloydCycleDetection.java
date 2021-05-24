

public class FloydCycleDetection {

    //O(n)
    public static boolean isfloydCycle(LinkedList ll){
        
        Node slow = ll.head;
        Node fast = ll.head;
        while(slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        LinkedList ll  = new LinkedList();
        ll.insertBeg(1);
        ll.insert(1, 4);
        ll.insertEnd(6);
        ll.insert(4, 5);
        ll.display();
        System.out.println(isfloydCycle(ll));

    }

}
