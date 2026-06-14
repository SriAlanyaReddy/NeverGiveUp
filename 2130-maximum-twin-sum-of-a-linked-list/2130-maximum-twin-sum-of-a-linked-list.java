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
    public int pairSum(ListNode head) {
        ListNode curr=head;
        Stack<Integer>st=new Stack<>();
        int n=0;
        while(curr!=null){
            st.push(curr.val);
            curr=curr.next;
            n=n+1;
        }
        curr=head;
        int max=Integer.MIN_VALUE;
        while(n/2>0){
            int twinsum=st.pop()+curr.val;
            max=Math.max(twinsum,max);
            n--;
            curr=curr.next;

        }
        return max;
    }
}