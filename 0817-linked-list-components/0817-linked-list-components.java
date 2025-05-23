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

import java.util.*;

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);  // For quick lookup
        }

        int count = 0;
        ListNode current = head;

        while (current != null) {
            // Check if this node is the start of a new component
            if (set.contains(current.val) && 
               (current.next == null || !set.contains(current.next.val))) {
                count++;
            }
            current = current.next;
        }

        return count;
    }
}
