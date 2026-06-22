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
    public int maxi_index(int[] a,int l,int r){
        int maxi=l;
        int max=Integer.MIN_VALUE;
        for(int i=l;i<r;i++){
            if(a[i]>a[maxi]){
                maxi=i;
                
            }
        }
        return maxi;
    }
    public TreeNode constructMaximumBinaryTree(int[] a) {
        int n=a.length;
        
        return find(0,n,a);
        
    }
    public TreeNode find(int l,int r,int[] a){
        if(l==r){
            return null;

        }
        int maxi=maxi_index(a,l,r);
        TreeNode newnode=new TreeNode(a[maxi]);
        newnode.left=find(l,maxi,a);
        newnode.right=find(maxi+1,r,a);
        return newnode;
    }
}