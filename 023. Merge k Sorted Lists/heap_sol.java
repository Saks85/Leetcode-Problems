/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min-heap

        for (ListNode l : lists) {
            while (l != null) {
                pq.offer(l.val);
                l = l.next;
            }
        }

        // Dummy node for building the result list
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }

        // Return the real head (skip dummy)
        return dummy.next;
    }
}
