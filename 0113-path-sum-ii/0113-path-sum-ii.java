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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        findpath(root,targetSum,res,ans);
        return res;
        
    }
    public void findpath(TreeNode root, int target,List<List<Integer>>ans,List<Integer>temp){
        if(root==null){
            return;
        }
         temp.add(root.val);
        if(root.val==target && root.left==null && root.right==null){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
       else{
        findpath(root.left,target-root.val,ans,temp);
        findpath(root.right,target-root.val,ans,temp);

       }
        
        temp.remove(temp.size()-1);
    }
}