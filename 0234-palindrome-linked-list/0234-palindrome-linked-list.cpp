/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode *temp = head;
        int c = 0;

        // Count the number of nodes in the linked list
        while (temp != NULL) {
            c = c + 1;
            temp = temp->next;
        }

        // Create an array to store the values of the linked list
        int *a = new int[c];
        temp = head; // Reset temp to the head

        // Populate the array with the values of the linked list
        for (int i = 0; i < c; i++) {
            a[i] = temp->val;
            temp = temp->next;
        }

        // Check if the array is a palindrome
        for (int i = 0, j = c - 1; i < c / 2; i++, j--) {
            if (a[i] != a[j]) {
                delete[] a; // Free the allocated memory before returning
                return false;
            }
        }

        delete[] a; // Free the allocated memory before returning
        return true;
    }
};
