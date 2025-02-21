class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev1 = dummy;

        // Move prev1 to the node before `left`
        for (int i = 1; i < left; i++) {
            prev1 = prev1.next;
        }

        ListNode curr = prev1.next;  // First node of the sublist
        ListNode prev = null;
        ListNode tail = curr;  // The first node of the sublist (will become the last after reversal)

        // Reverse the sublist from left to right
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Reconnect the reversed sublist with the rest of the list
        tail.next = curr;  // Connect the last node of the reversed sublist to `curr`
        prev1.next = prev;  // Connect `prev1` to the new first node of the reversed sublist

        return dummy.next; // Return the updated head
    }
}
