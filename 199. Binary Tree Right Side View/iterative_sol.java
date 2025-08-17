//this is similar to top order and bottom order -- uses Level Order traversal
//recursive is smaller and more optimal for SC


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
    class pair{
        TreeNode node; int row;
        pair(TreeNode node, int row){
            this.node= node;
            this.row= row;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans= new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer,Integer> mp= new TreeMap<>();
        Queue<pair> q= new LinkedList<>();
        q.offer(new pair(root, 0));
        while(!q.isEmpty()){
            pair p= q.poll();
            mp.put(p.row, p.node.val);
            
            if(p.node.left!=null){
                q.offer(new pair(p.node.left, p.row+1));
            }
            if(p.node.right!= null){
                q.offer(new pair(p.node.right,p.row+1));
            }
        }
        for(Integer ys: mp.values()){
            ans.add(ys);
        }
        return ans;
    }
}
