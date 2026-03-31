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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> pos = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        //step 1: traverse to get minima maxima
        while(curr.next!=null){
            if((prev.val < curr.val && curr.val > curr.next.val) || (prev.val>curr.val && curr.val< curr.next.val)){
                pos.add(index);
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        //step2 : check pos
        if(pos.size()<=1){
            return new int[]{-1,-1};
        }

        //step3: getting min dist
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < pos.size();i++){
            min = Math.min(min, pos.get(i) - pos.get(i-1));
        }

        //step 4: getting max dist
        int max = pos.get(pos.size()-1) - pos.get(0);

        return new int[]{min,max};
    }
}