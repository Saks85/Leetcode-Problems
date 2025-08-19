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
    public void parent(TreeNode root, Map<TreeNode, TreeNode> mp){
        if(root==null) return ;

        if (root.left!= null){
            mp.put(root.left, root);
            parent(root.left, mp);
        }
        if (root.right!=null){
            mp.put(root.right, root);
            parent(root.right, mp);
        }
        return;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans= new ArrayList<>();
        if (target== null || root==null) return ans;
        if(k==0) {
            ans.add(target.val);
            return ans;
        }
        Map<TreeNode, TreeNode> mp= new HashMap<>();
        parent(root, mp);
        //System.out.println(mp);
        Queue<TreeNode> q= new LinkedList<>();
        Set<TreeNode> visited= new HashSet<>();
        
        q.add(target);
        visited.add(target);
        int dist=0;
        while (!q.isEmpty()){
            int size=q.size();
            //very important to initialize separately 
            //if use q.size() directly, the value is checked for every iteration
            //thus value may be changed if new element is added
            if (dist==k){
                for (int i =0; i<size; i++){
                    ans.add(q.poll().val);
                }
                return ans;
            }
            dist++;
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll();
                //visited.add() returns true if added successfully
                if(curr.left!=null && visited.add(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right!=null && visited.add(curr.right)){
                    q.add(curr.right);
                }
                TreeNode parentNode = mp.get(curr);
                if (parentNode != null && visited.add(parentNode)) {
                    q.add(parentNode);
                }
            }
            
        }
        return ans;

    }
}
