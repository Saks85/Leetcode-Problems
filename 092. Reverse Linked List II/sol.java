class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to the node before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) prev = prev.next;

        // Now reverse [left..right]
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode reversalPrev = null;

        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = reversalPrev;
            reversalPrev = curr;
            curr = next;
        }

        // Connect the pieces
        prev.next.next = curr;     // tail connects to afterRight
        prev.next = reversalPrev;  // beforeLeft connects to new head of reversed part

        return dummy.next;
    }
}
