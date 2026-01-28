/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void preorder(TreeNode* root,set<int> &ans){
        if(root==NULL){
            return;
        }
     
        preorder(root->left,ans);
        ans.insert(root->val);
        preorder(root->right,ans);
        }

    
    int kthSmallest(TreeNode* root, int k) {
        set<int>ans;
       preorder(root,ans);
       int s=ans.size();
       auto it=ans.begin();
       advance(it,k-1);
       if(it!=ans.end()){
           return *it;
       }
       return -1;
    }
};