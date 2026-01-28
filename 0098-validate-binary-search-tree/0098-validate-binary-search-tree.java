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
    public boolean isValidBST(TreeNode root) {
        return validate(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public boolean validate(TreeNode root,int minvalue,int maxvalue){
        if(root==null){
            return true;
        }
        if(root.val<=minvalue || root.val>=maxvalue){
            return false;
        }
        return validate(root.left,minvalue,root.val) && validate(root.right,root.val,maxvalue);
    }
}