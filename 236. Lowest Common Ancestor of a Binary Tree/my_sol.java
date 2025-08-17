/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //found path of each in 2 arrays then compared to get the LCU
    public boolean findPath(TreeNode root, TreeNode x, List<TreeNode> path){
        if(root==null) return false;
        path.add(root);
        if(root==x) return true;
        if(findPath(root.left,x, path) || findPath(root.right, x, path)) return true;
        path.remove(root);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> parr= new ArrayList<>();
        List<TreeNode> qarr= new ArrayList<>();
        findPath(root, p,parr);
        findPath(root,q,qarr);
        int i=0;
        while (i<parr.size() && i<qarr.size()){
            if(parr.get(i)!=qarr.get(i)) break;
            i++;
        }
        return parr.get(i-1);        
    }
}
