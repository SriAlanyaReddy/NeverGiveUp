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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>res=new ArrayList<>();
       
        duplicates(new HashMap<>(),root,res);
        return res;
        
    }
    public String duplicates(HashMap<String,Integer>map,TreeNode root,List<TreeNode>res){
        if(root==null){
            return "#";
        }
        String s=root.val+",";
        s+=duplicates(map,root.left,res)+","+duplicates(map,root.right,res);
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2){
            res.add(root);
        }
        return s;

    }
    
}