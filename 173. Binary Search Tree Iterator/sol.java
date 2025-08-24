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
class BSTIterator {
    Stack<TreeNode> st= new Stack<>();

    public BSTIterator(TreeNode root) {
        pushall(st,root);   
    }
    private void pushall(Stack<TreeNode> st, TreeNode cur){
        while(cur!=null){
            st.push(cur);
            cur=cur.left;
        }
    }
    
    public int next() {
        TreeNode ele= st.pop();
        pushall(st,ele.right);
        return ele.val;               
    }
    
    public boolean hasNext() {
        if(!st.isEmpty()) return true;
        return false;         
    } 
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
