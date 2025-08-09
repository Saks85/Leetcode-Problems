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
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> ans= new ArrayList<>();
        if (root==null) return new ArrayList<List<Integer>>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> sub= new ArrayList<>();
            int levelNum= q.size();
            for(int i=0; i<levelNum; i++){
                if(q.peek().left != null)q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                sub.add(q.poll().val);
            }
            ans.add(sub);
        }
        return ans;

    }
}
