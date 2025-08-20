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
    private TreeNode builder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inhash){
        if(preStart==preEnd) return new TreeNode(preorder[preStart]);

        int ind= inhash.get(preorder[preStart]);//this is root index in inorder
        int length= ind-inStart;
        //length of left= ind-inStart
        TreeNode left=(ind==inStart)?null: builder(preorder,preStart+1,preStart+length,inorder,inStart,ind-1,inhash);
        TreeNode right=(inEnd==ind)?null: builder(preorder,preStart+length+1,preEnd, inorder, ind+1, inEnd,inhash);
        return new TreeNode(preorder[preStart],left,right);
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inhash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inhash.put(inorder[i], i);
        }
        return builder(preorder, 0,preorder.length-1, inorder, 0,inorder.length-1, inhash);
    }
}
