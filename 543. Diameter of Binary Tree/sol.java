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
    public int findH(TreeNode node, int[] maxi){
        if(node == null) return 0;
        int lh= findH(node.left, maxi);
        int rh= findH(node.right, maxi);

        maxi[0]= Math.max(maxi[0], lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter= new int[1];
        //using array as pointers are not available in java
        //thus can't call an integer by reference
        findH(root,diameter);
        return diameter[0];
    }
}
