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
    public ListNode modifiedList(int[] a, ListNode head) {
        int n=a.length;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(a[i]);

        }
        while(head!=null && set.contains(head.val) ){
            head=head.next;
        }
        ListNode current=head,prev=null;
        while(current.next!=null){
            if(set.contains(current.next.val)){
                
              
                    current.next=current.next.next;
                



            }
            else{
                current=current.next;

            }
           
            
        }
        return head;
    }
}