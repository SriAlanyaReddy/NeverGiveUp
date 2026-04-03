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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len=0;
        List<Integer>a=new ArrayList<>();
        ListNode current=head;
        while(current!=null){
             a.add(current.val);
            current=current.next;
           
            len++;
        }
        return find(a,0,len-1);
    }
    public TreeNode find(List<Integer>a,int left,int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;
        int val=a.get(mid);
        TreeNode node=new TreeNode(val);
        node.left=find(a,left,mid-1);
        node.right=find(a,mid+1,right);
        return node;
    }
}