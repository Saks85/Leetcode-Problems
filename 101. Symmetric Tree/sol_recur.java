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
    public boolean checkSym(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if (p==null || q==null) return false;
        return (p.val==q.val)& checkSym(p.left,q.right)& checkSym(p.right,q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null ) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left == null || root.right==null) return false;

        return checkSym( root.left,root.right);
        
    }
}
