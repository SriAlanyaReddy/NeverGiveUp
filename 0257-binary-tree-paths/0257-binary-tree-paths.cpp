



class Solution {
public:
    void path(TreeNode* root, string currentPath, vector<string>& v) {
        if(root==NULL){
            return ;
        }
        currentPath+=to_string(root->val);
        if(root->left==NULL && root->right==NULL){
            v.push_back(currentPath);
        }
       
        path(root->left,currentPath+"->",v);
        path(root->right,currentPath+"->",v);

    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string>v;
        path(root,"",v);
        return v;
    }
};


