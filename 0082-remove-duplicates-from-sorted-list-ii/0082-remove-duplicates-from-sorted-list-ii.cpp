class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // Dummy node before head
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;

        ListNode* prev = dummy;
        ListNode* curr = head;

        while (curr != NULL) {
            // If duplicates found
            if (curr->next != NULL && curr->val == curr->next->val) {
                int val = curr->val;

                // Skip all nodes with this value
                while (curr != NULL && curr->val == val) {
                    curr = curr->next;
                }

                prev->next = curr;
            } 
            else {
                // No duplicate → move prev
                prev = curr;
                curr = curr->next;
            }
        }

        return dummy->next;
    }
};
