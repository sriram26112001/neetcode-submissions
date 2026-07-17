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
        if(head == null || head.next == null)
        {
            return;
        }
        ListNode t1 = head;
        ListNode tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        ListNode t2 = tail;
        //fast and slow pointer approach
        ListNode mid = findMiddleNode(head);
        mid = reverse(mid);
        while(t1 != t2 && t1.next != t2)
        {
            ListNode newt1 = t1.next;
            ListNode newt2 = t2.next;
            t1.next = t2;
            t1 = newt1;
            t2.next = t1;
            t2 = newt2;
        }
        return;
    }
    public ListNode findMiddleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        while(next != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }
}
