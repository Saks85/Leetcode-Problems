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
    //Intuition: For zigzag simply do the transversal of level order
    //set a flipping variable l2r that simply prints the list in reverse order for every alternate iteration
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list= new ArrayList<>();
        if (root==null) return list;
        Queue<TreeNode> st= new LinkedList<>();
        st.offer(root);
        boolean l2r=true;
        while(!st.isEmpty()){
            int level= st.size();
            List<Integer> sub= new ArrayList<>();
            
            for (int i = 0; i < level; i++) {
                TreeNode temp = st.poll();
                if (l2r) sub.add(temp.val);
                else sub.add(0,temp.val);

                // Always enqueue left then right
                if (temp.left != null) st.offer(temp.left);
                if (temp.right != null) st.offer(temp.right);
            }
            list.add(sub);
            l2r = !l2r;
        }
        return list;        
    }
}
