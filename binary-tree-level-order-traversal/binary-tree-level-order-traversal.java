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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
            
        que.offer(root);
        
        while (!que.isEmpty()) {
            int queSize = que.size();
            List<Integer> list = new ArrayList<Integer>();
            
            for (int i = 0; i < queSize; i++) {
                TreeNode node = (TreeNode) que.poll();
                list.add(node.val);
                
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }

            }
            ret.add(list);
            
            
        }
        
        return ret;
    }
}