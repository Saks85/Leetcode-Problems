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
    private int maxPath(TreeNode root, int[] maxi){
        if (root==null) return 0;

        int leftSum= Math.max(0,maxPath(root.left,maxi));
        int rightSum= Math.max(0,maxPath(root.right,maxi));

        maxi[0]= Math.max(maxi[0], leftSum+rightSum+ root.val);

        return root.val+ Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxP= new int[1];
        maxP[0]=Integer.MIN_VALUE;
        maxPath(root,maxP);
        return maxP[0];              
    }
}
