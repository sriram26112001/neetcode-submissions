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
        if(head == null) return head;
        ListNode temp = head;
        ListNode prevLast = null;
        while(true)
        {
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null)
            {
                if(prevLast != null)
                {
                    prevLast.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;  
            kthNode.next = null;
            reverse(temp);
            if(temp == head)
            {
                head = kthNode;
            }
            else
            {
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
    public ListNode findKthNode(ListNode node,int k)
    {
        int count = 1;
        ListNode temp = node;
        while(temp != null && count != k)
        {
            count ++;
            temp = temp.next;
        }
        return temp;
    }
    public void reverse(ListNode head)
    {
         if(head == null || head.next == null)
        {
            return;
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
        return;
    }
}
