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
    public void getPath(TreeNode root, List<String> ans,List<Integer> st ){
        if(root==null) return;
        st.add(root.val);
        if(root.right==null && root.left==null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < st.size(); i++) {
                sb.append(st.get(i));
                if (i < st.size() - 1) sb.append("->");
            }
            ans.add(sb.toString());            
        }
        getPath(root.left,ans, st);
        getPath(root.right, ans, st);
        st.remove(st.size()-1);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans= new ArrayList<>();
        if (root==null) return ans;
        getPath(root, ans, new ArrayList<>());
        return ans;

        
    }
}
