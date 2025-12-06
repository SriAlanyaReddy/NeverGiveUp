/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        
        /*if(root==null) return 0;
        int c=1,max=root.val;
        while(root!=null){
            if(root.left!=null){
                root=root.left;
                if(root.val>max){
                    max=root.val;
                    c++;
                }
            }
            if(root.right!=null){
                root=root.right;
                if(root.val>max){
                    max=root.val;
                    c++;
                }
            }
        }
        return c;
        */
        return findcount(root,root.val);
        
    }
    public int findcount(TreeNode root,int c,int maxn){
        if(root==null){
            return 0;
        }
        int c=0;
        if(root.val>=maxn){
            c=1;
            maxn=root.val;
            
        }
       c+= findcount(root.left,maxn)+ findcount(root.right,maxn);
       return c;
       
    }

}