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
        if(lists.length == 0) return null;
        ListNode head = lists[0];
        for(int i = 1;i < lists.length;i++)
        {
            head = merge(head,lists[i]);
        }
        return head;
    }
    public ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode dnode = new ListNode(-1);
        ListNode temp = dnode;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(t1 != null && t2 != null)
        {
            if(t1.val < t2.val)
            {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else
            {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null)
        {
            temp.next = t1;
        }
        else
        {
            temp.next = t2;
        }
        return dnode.next;
    }
}
