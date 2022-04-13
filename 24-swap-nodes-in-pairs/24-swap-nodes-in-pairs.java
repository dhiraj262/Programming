/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(0);
         dummyHead.next=head;
         ListNode prev = dummyHead, curr = head;
        while(curr!=null && curr.next !=null){
            prev.next = curr.next;
            prev = prev.next;
            curr.next = prev.next;
            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}