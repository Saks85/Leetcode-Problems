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
    private TreeNode constructBST(int[] pre, int start, int end){
        if (start>end) return null;
        TreeNode root= new TreeNode(pre[start]);
        int i=start+1;
        while(i<=end && pre[i]<pre[start]){
            i++;
        }
        root.left= constructBST(pre, start+1,i-1);
        root.right= constructBST(pre, i,end);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,0,preorder.length-1);   
    }
}
