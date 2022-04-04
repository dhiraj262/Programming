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
    public ListNode swapNodes(ListNode head, int k) {
        
       ListNode slow = head, fast = head, kNode = head;
        //1st node
        for(int i = 0; i < k - 1; i++){
            fast = fast.next;
            kNode = fast;
        }
        //2nd node
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        //swap 1st and 2nd
        int temp = slow.val;
        slow.val = kNode.val;
        kNode.val = temp;
        return head;
        
    }
}