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
    private void inorderSearch(TreeNode root, int k, int[] count){
      //can opt for morris traversal to reduce space used in recursive traversal
        if (root==null) return ;
        //left root right
        inorderSearch(root.left,k,count);
        if (++count[0]==k) count[1]=root.val;
        inorderSearch(root.right,k,count);
    }
    public int kthSmallest(TreeNode root, int k) {
        //inorder gives the sorted order in BST
        int[] count= new int[2]; //[0]= count , [1]=answer
        inorderSearch(root,k,count);
        return count[1];        
    }
}
