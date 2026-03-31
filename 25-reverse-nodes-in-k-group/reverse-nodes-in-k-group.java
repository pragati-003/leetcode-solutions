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
    public ListNode reverseKGroup(ListNode head, int k) {
         // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointer to the tail of the last reversed group
        ListNode grpPrev = dummy;

        while (true) {
            // Get the k-th node in the current group
            ListNode kth = getKthNode(grpPrev, k);
            if (kth == null) break;

            // Store the next group’s head
            ListNode grpNext = kth.next;

            // Reverse the current k-group
            ListNode prev = grpNext;
            ListNode curr = grpPrev.next;

            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the previous group to the reversed group
            ListNode temp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = temp;
        }

        // Return the new head
        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}