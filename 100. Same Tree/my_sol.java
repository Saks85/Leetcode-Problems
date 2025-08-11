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
    public List<Integer> preorder(TreeNode r, List<Integer> list){
         if (r == null) {
            list.add(null); // mark null to preserve structure
            return list;
        }
        list.add(r.val);
        preorder(r.left, list);
        preorder(r.right, list);
        return list;
    }

    public List<Integer> inorder(TreeNode r, List<Integer> li){
        if (r == null) {
            li.add(null); // mark null to preserve structure
            return li;
        }
        
        inorder(r.left,li);
        li.add(r.val);
        inorder(r.right,li);

        return li;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Preorder comparison
        List<Integer> plist = preorder(p, new ArrayList<>());
        List<Integer> qlist = preorder(q, new ArrayList<>());
        if (!plist.equals(qlist)) return false;

        // Inorder comparison
        plist = inorder(p, new ArrayList<>());
        qlist = inorder(q, new ArrayList<>());
        if (!plist.equals(qlist)) return false;

        return true;

    }
}
