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
    TreeNode* removeLeafNodes(TreeNode* root, int t) {
        TreeNode*ans=dele(root,t);
        return ans;
    }
    TreeNode* dele(TreeNode*root,int t){
     if(root==NULL){
            return NULL;
        }
         root->left=dele(root->left,t);
        root->right=dele(root->right,t);
        if(root->left==NULL && root->right==NULL && root->val==t){
            return NULL;
        }
       
        return root;
    }
};