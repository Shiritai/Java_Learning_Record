import java.util.List;

/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 */

// @lc code=start
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
    /* use dummy head */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(val - 1, head), cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else 
                cur = cur.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

