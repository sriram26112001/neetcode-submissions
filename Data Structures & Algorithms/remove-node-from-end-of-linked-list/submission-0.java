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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        int target = size - n;
        if(n > size)
        {
            return head;
        }
        else if(target == 0)
        {
            head = head.next;
        }
        else
        {
            temp = head;
            int count = 1;
            while(count != target)
            {
                count++;
                temp= temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}
