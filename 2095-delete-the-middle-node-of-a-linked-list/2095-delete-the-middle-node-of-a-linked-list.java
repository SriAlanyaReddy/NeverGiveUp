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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;

        }
        if(prev==null){
            return head.next;
        }
        prev.next=slow.next;
        slow.next=null;
        return head;
    }
}