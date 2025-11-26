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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* curr = head;
        ListNode* newHead = nullptr;
        ListNode* tail=nullptr;  
        while(curr!=nullptr){
            if(curr->next==NULL || curr->val!=curr->next->val){
                if(newHead==nullptr){
                    newHead=tail=curr;
                }
                else{
                    tail->next=curr;
                    tail=curr;
                }
                curr=curr->next;
            }
            else{
                int val = curr->val;

while (curr != nullptr && curr->val == val) {
    ListNode* temp = curr;
    curr = curr->next;
    delete temp;
}

            }
        }
             if (tail != nullptr) {
            tail->next = nullptr; // Set the next of the last distinct node to null
        }
        return newHead;
        }
};
