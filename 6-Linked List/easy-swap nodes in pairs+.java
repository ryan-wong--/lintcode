/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    private void switch_(ListNode prev, ListNode cur, ListNode after){
        prev.next = after;
        cur.next = after.next;
        after.next = cur;
    }
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode odd = head, even = head.next;
        //注意区分奇数个和偶数个节点的终结条件
        while(even!=null){
            switch_(prev, odd, even);
            prev = prev.next.next;
            odd = prev.next;
            if(odd==null){
            	break;
            }
            even = prev.next.next;
        }
        return dummy.next;
    }
}