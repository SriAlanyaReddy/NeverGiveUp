/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {

    // Reverse Linked List
    public ListNode reverseLL(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode nextNode = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public ListNode doubleIt(ListNode head) {

        // Step 1: Reverse the list
        ListNode reversedHead = reverseLL(head);

        int carry = 0;

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        // Step 2: Double each digit
        while (reversedHead != null) {

            int sum = carry + (reversedHead.val * 2);

            carry = sum / 10;

            ListNode newNode =
                    new ListNode(sum % 10);

            current.next = newNode;
            current = newNode;

            reversedHead = reversedHead.next;
        }

        // Step 3: If carry remains
        if (carry > 0) {

            current.next =
                    new ListNode(carry);
        }

        // Step 4: Reverse again to get answer
        return reverseLL(dummyNode.next);
    }
}