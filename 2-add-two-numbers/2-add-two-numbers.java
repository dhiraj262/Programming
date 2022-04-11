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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        int sum = 0;
        ListNode res = curr;
        
        while(l1!=null || l2!=null) {
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            
            sum = sum > 9 ? 1:0;
            
        }
        
        if(sum > 0){
            curr.next = new ListNode(sum);
        }
        
        return res.next;
    }
}