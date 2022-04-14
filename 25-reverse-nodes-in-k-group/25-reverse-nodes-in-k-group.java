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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead , nex = dummyHead, pre = dummyHead;
        int len = 0;
        while(curr.next != null){
            curr = curr.next;
            len++;
        }
        while(len >= k){
            curr = pre.next;
            nex = curr.next;
            for(int i = 1; i < k; i++){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            len-=k;
        }
        return dummyHead.next;
        
    }
}