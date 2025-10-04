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
    public ListNode mergeTwoLists(ListNode list11, ListNode list22) {
       
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

       
        while (list11 != null && list22 != null) {
            if (list11.val <= list22.val) {
                tail.next = list11;
                list11 = list11.next;
            } else {
                tail.next = list22;
                list22 = list22.next;
            }
            tail = tail.next;
        }

       
        if (list11 != null) tail.next = list11;
        else tail.next = list22;

        return dummy.next;
    }
}
