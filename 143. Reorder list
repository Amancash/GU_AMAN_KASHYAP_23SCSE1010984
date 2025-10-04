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
    public void reorderList(ListNode head) {
        if (head == null) return;
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            list1.add(cur.val);
            cur = cur.next;
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        int i = 0, j = list1.size() - 1;
        while (i <= j) {
            if (i == j) list2.add(list1.get(i));
            else {
                list2.add(list1.get(i));
                list2.add(list1.get(j));
            }
            i++; j--;
        }
        cur = head;
        int idx = 0;
        while (cur != null && idx < list2.size()) {
            cur.val = list2.get(idx++);
            cur = cur.next;
        }
    }
}
