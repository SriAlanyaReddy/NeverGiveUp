class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        
        // Check if linked list starts at this node OR look in left/right subtrees
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node) {
        if (head == null) return true; // Entire linked list matched
        if (node == null) return false; // Tree ended before full match
        if (head.val != node.val) return false; // Values don't match
        
        // Continue checking both left and right paths
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }
}
