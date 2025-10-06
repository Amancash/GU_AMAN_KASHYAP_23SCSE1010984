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
    public ListNode partition(ListNode head, int x) {
        ListNode smalllist = new ListNode(-1);
        ListNode biglist = new ListNode (-1);
        ListNode small = smalllist;
        ListNode big = biglist;
        ListNode temp =head;
        while(temp != null){
            if(temp.val < x){
                small.next = temp;
                small = small.next;
            }else{
                big.next=temp;
                big = big.next;
            }
            temp = temp.next;
        }
        big.next = null;
        small.next = biglist.next;
        return smalllist.next;
    }
}
