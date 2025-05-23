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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current=head;
        int len=0;
        while(current!=null){
            len++;
            current=current.next;
        }
        ListNode[] res=new ListNode[k];
        int parts=len/k;
        int extra=len%k;
        current=head;
        ListNode prev=head;
        for(int i=0;i<k;i++){
            res[i]=current;
            int j=0;
            while(j<parts+((extra>0)?1:0)){
                prev=current;
                current=current.next;
                j++;
            }
            if (prev != null) prev.next = null;

            extra--;
        }
        return res;
    }
}