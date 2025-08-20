class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inhash;

    private TreeNode builder(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int ind = inhash.get(rootVal);

        root.left = builder(preorder, inStart, ind-1);
        root.right = builder(preorder, ind+1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inhash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inhash.put(inorder[i], i);
        }
        return builder(preorder, 0, inorder.length-1);
    }
}
