/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0,sizeB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=null){
            sizeA++;
            tempA = tempA.next;
        }

        while(tempB!=null){
            sizeB++;
            tempB = tempB.next;
        }

        int m = 0;
        tempA = headA;
        tempB = headB;
        if(sizeA > sizeB){
            m = sizeA-sizeB;
            for(int i = 1;i<=m;i++){
            tempA = tempA.next;
            }
        }else{
            m = sizeB- sizeA;
            for(int i = 1;i<=m;i++){
            tempB = tempB.next;
            }
        }
        while(tempA!=null){
            if(tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}