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
    private Map<Integer, Integer> inhash = new HashMap<>();
    private TreeNode builder(int[] preorder, int preStart, int preEnd, int inStart){
        if(preStart==preEnd) return new TreeNode(preorder[preStart]);
        if (preStart>preEnd) return null;

        int ind= inhash.get(preorder[preStart]);//this is root index in inorder
        int length= ind-inStart;
        //length of left= ind-inStart
        TreeNode left= builder(preorder,preStart+1,preStart+length,inStart);
        TreeNode right=builder(preorder,preStart+length+1,preEnd,ind+1);
        return new TreeNode(preorder[preStart],left,right);
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            inhash.put(inorder[i], i);
        }
        return builder(preorder, 0,preorder.length-1, 0);
    }
}
