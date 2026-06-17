/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* u, TreeNode* v) {
         if(root==NULL || root==u ||root==v){
        return root;
    }
 TreeNode*left=lowestCommonAncestor(root->left, u, v);
    TreeNode* right=lowestCommonAncestor(root->right,u,v);
    if(left!=NULL && right!=NULL)  {
        return root;
    }
    return  left!=NULL?left:right;
    }
};