/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    private Node helper(Node head,Node prev){
        Node curr= head;
        while (curr!=null){
            //if no child go on
            if (curr.child==null){
                prev=curr;
                curr=curr.next;    
            }
            else{
                Node after = curr.next;//store the curr.next to be added after child

                curr.next=curr.child; //added child as curr.next
                curr.child.prev=curr;//added prev of child as curr
                curr.child=null;// flattened the child 

                Node last= helper(curr.next, curr);
                //   to further flatten the child's next level and return the tail

                last.next=after;// connect tail of child to the after
                //hence complletely flatenning
                if (after!=null) after.prev=last;

                //moving ahead
                curr=after;
                prev=last;
            }

        }
        return prev;// to return the tail
    }
    public Node flatten(Node head) {
        helper(head, null);
        return head;
    }
}
