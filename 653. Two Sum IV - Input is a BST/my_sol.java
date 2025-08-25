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

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set= new HashSet<>();
        TreeNode cur= root;
        //inorder
        while (cur!=null){
            if (cur.left==null){
                if(set.contains(k-cur.val)) return true;
                set.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev= cur.left;
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    if(set.contains(k-cur.val)) return true;
                    set.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return false;      
        
    }
}
