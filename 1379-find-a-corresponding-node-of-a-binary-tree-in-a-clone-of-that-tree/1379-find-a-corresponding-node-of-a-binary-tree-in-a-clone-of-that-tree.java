/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        find(original,cloned,target);
        return ans;
        
    }
    public void find(TreeNode o,TreeNode cl,TreeNode target){
        if(o==null){
            return ;
        }
        
        find(o.left,cl.left,target);
        if(o==target){
            ans=cl;
        }
        find(o.right,cl.right,target);
    }
}