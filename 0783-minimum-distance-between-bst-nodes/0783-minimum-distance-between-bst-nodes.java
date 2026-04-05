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
    int min=Integer.MAX_VALUE;
    Integer prev=null;
    public int minDiffInBST(TreeNode root) {
        /// 1way of solution is that inorder travesal of bst tree gives sorted order then we can find minimum difference btween nodes
        inorder(root);
        return min;
        
    }
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        if(prev!=null){
            min=Math.min(min,root.val-prev);
        }
        prev=root.val;
        inorder(root.right);
    }
}