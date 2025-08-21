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
  //TC-o(2n) SC-o(2n)
    private void add(TreeNode root,Queue<TreeNode> pre){
        if(root==null) return;
        pre.offer(root);
        add(root.left,pre);
        add(root.right,pre);

    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        Queue<TreeNode> pre= new LinkedList<>();
        add(root,pre);
        TreeNode r= pre.poll();
        while(!pre.isEmpty()){
            r.left=null;
            r.right=pre.poll();
            r=r.right;            
        }        
    }
  
}
