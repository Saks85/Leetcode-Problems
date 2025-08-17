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
    class tuple{
        TreeNode root; int row; int col;
        public tuple(TreeNode root, int row, int col){
            this.root=root;
            this.row= row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<tuple> q= new LinkedList<>();
        Map<Integer,Map<Integer, PriorityQueue<Integer>>> mp= new TreeMap<>();
        //treemap to keep sorted order of rows
        q.offer(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple t= q.poll();
            int r= t.row;
            int c= t.col;

            if (!mp.containsKey(c)){
                mp.put(c,new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            if (!mp.get(c).containsKey(r)){
                mp.get(c).put(r,new PriorityQueue<Integer>());
            }
            mp.get(c).get(r).offer(t.root.val);

            if(t.root.left!=null){
                q.offer(new tuple(t.root.left, r+1, c-1));
            }

            if(t.root.right!=null){
                q.offer(new tuple(t.root.right, r+1, c+1));
            }

                       
        }
        List<List<Integer>> list= new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> ys : mp.values()){
            //if had used hashMap, the order could be random
            // but with tree map the order is sorted
            list.add(new ArrayList<>());
            for( PriorityQueue<Integer> pq: ys.values()){
                while (!pq.isEmpty()) list.get(list.size()-1).add(pq.poll());
            }
        }
        return list;        
    }
}
