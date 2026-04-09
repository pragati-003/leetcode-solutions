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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(sum % 10);

            carry = sum/10;

            temp = temp.next;
        }
        
        ListNode head = reverse(dummy.next);
        
        while(head!=null && head.val == 0){
            head = head.next;
        }
        if(head == null) return new ListNode(0);
        
        return head;
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}