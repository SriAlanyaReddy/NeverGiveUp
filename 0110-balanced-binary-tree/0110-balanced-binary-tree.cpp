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
    bool isBalanced(TreeNode* root) {
       if(root==NULL){
           return true;
       }
       int diff=heightbalance(root->left)-heightbalance(root->right);
       bool lh=isBalanced(root->left);
       bool rh=isBalanced(root->right);
       if(diff<=1 && diff>=-1 &&lh && rh){
           return true;
       }
       return false;
    }

 int heightbalance(TreeNode*root){
  if(root==NULL){
      return 0;
  }
  int lh=heightbalance(root->left);
  int rh=heightbalance(root->right);
  return max(rh,lh)+1;
}
};
      