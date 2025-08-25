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
    private void pushNext(Stack<TreeNode> st, TreeNode cur) {
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }
    }

    private void pushBefore(Stack<TreeNode> st, TreeNode cur) {
        while (cur != null) {
            st.push(cur);
            cur = cur.right;
        }
    }

    private int next(Stack<TreeNode> st) {
        TreeNode ele = st.pop();
        pushNext(st, ele.right);
        return ele.val;
    }

    private int before(Stack<TreeNode> st) {
        TreeNode ele = st.pop();
        pushBefore(st, ele.left);
        return ele.val;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Stack<TreeNode> nextST = new Stack<>();
        Stack<TreeNode> beforeST = new Stack<>();

        pushNext(nextST, root);
        pushBefore(beforeST, root);

        int small = next(nextST);
        int large = before(beforeST);

        // stop when small >= large (like two-pointer crossing)
        while (small < large) {
            int sum = small + large;
            if (sum == k) return true;
            else if (sum < k) {
                if (!nextST.isEmpty()) small = next(nextST);
                else break;
            } else {
                if (!beforeST.isEmpty()) large = before(beforeST);
                else break;
            }
        }
        return false;
    }
}
