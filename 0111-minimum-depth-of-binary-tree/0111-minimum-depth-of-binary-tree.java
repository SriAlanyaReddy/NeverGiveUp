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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int leftheight=minDepth(root.left);
        int rightheight =minDepth(root.right);
        if(leftheight==0 || rightheight==0){
            return leftheight+rightheight+1;
        }
        return Math.min(leftheight,rightheight)+1;
    }
}