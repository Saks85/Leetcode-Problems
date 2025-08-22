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
    //this function returns the changed nodes
    private TreeNode rearrange(TreeNode root){
        if (root.left== null) return root.right;
        else if(root.right==null) return root.left;
        else{
            TreeNode rightChild= root.right;
            //connect rightchild to rightmost of leftchild
            TreeNode lastRight=root.left;
            while(lastRight.right!=null) lastRight=lastRight.right;
            lastRight.right=rightChild;
            return root.left;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key) return rearrange(root);
        TreeNode cur=root;
        //searching the value
        while (cur!=null ){
            if(cur.val>key) {
                if(cur.left!=null && cur.left.val==key){
                    cur.left=rearrange(cur.left);
                    break;
                }
                cur=cur.left;
            }
            else  {
                if(cur.right!=null && cur.right.val==key){
                    cur.right=rearrange(cur.right);
                    break;
                }
                cur=cur.right;

            }
        }
        return root;
    }
}
