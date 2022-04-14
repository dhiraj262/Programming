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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //Find mid
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next != null){
            slow  = slow.next;
            fast = fast.next.next;
        }
        
        //After reaching mid we have to reverse the elements from mid to end
        //1->2->3->4->5->6 to 1->2->3->6->5->4
            ListNode prev=slow;
            ListNode curr=slow.next;
            while(curr.next!=null){
                ListNode temp=curr.next;
                curr.next=temp.next;
                temp.next=prev.next;
                prev.next=temp;
            }
        //Reorder from start and mid at the same time :  1->2->3->6->5->4 to 1->6->2->5->3->4
            slow=head;
            fast=prev.next;
            while(slow!=prev){
                prev.next=fast.next;
                fast.next=slow.next;
                slow.next=fast;
                slow=fast.next;
                fast=prev.next;
            }
    }
}