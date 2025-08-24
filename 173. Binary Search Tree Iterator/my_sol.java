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
    List<Integer> inorder= new ArrayList<>();
    int pointer;

    public BSTIterator(TreeNode root) {
        inorder= inorderT(root);
        this.pointer=-1;       
    }

    private List<Integer> inorderT(TreeNode root){
        List<Integer> inorder= new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                inorder.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    inorder.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return inorder;
    }
    
    public int next() {
        if(hasNext()){
            return inorder.get(++pointer);
        }
        return -1;               
    }
    
    public boolean hasNext() {
        if(pointer+1<inorder.size()) return true;
        return false;         
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
