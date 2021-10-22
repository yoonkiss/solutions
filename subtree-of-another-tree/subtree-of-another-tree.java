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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        if (isSame(root, subRoot)) {
            return true;
        }
        
        // 하나라도 true면 true를 반환한다
        return isSubtree(root.left, subRoot) || isSubtree(root.right,  subRoot);
        
        
    }
    
    private boolean isSame(TreeNode originRoot, TreeNode destRoot) {
        if (originRoot == null && destRoot == null) {
            return true;
        }
        
        if (originRoot == null || destRoot == null) {
            return false;
        }
        
        if (originRoot.val != destRoot.val) {
            return false;
        }
        
        return isSame(originRoot.left, destRoot.left) && isSame(originRoot.right, destRoot.right);
    }
}