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
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Queue<TreeNode>parents=new LinkedList<>();
            int sum=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                parents.add(current);
                if(current.left!=null){
                    sum+=current.left.val;
                    q.add(current.left);
                }
                if(current.right!=null){
                     sum+=current.right.val;
                    q.add(current.right);

                }
            }
            for(TreeNode parent:parents){
                int t=sum;
                if(parent.left!=null) t-=parent.left.val;
                if(parent.right!=null) t-=parent.right.val;
                if(parent.left!=null) parent.left.val=t;
                if(parent.right!=null) parent.right.val=t;

            }
        }
        return root;
    }
}