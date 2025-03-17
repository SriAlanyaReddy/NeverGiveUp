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
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        rob(root.left);
        rob(root.right);
        int robthisnode=root.val;
        int dontrobthisnode=0;
        if(root.left!=null){
            dontrobthisnode+=root.left.val;
            if(root.left.left!=null){
                robthisnode+=root.left.left.val;
            }
             if(root.left.right!=null){
                robthisnode+=root.left.right.val;
            }

        }
        if(root.right!=null){
            dontrobthisnode+=root.right.val;
            if(root.right.right!=null){
                robthisnode+=root.right.right.val;
            }
            if(root.right.left!=null){
                robthisnode+=root.right.left.val;


            }
        }
     root.val=Math.max(robthisnode,dontrobthisnode);
     return root.val;


    }
}