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

    private boolean check(TreeNode root,long min, long max){
        if(root==null) return true;

        boolean left= check(root.left,min, (long)root.val-1);
        boolean right= check (root.right, (long)root.val+1, max);

        if(!left || !right) return false;

        if((root.val >= min & root.val<=max)) return true;
        return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        return check(root,Integer.MIN_VALUE, Integer.MAX_VALUE);        
        
    }
        
} 
