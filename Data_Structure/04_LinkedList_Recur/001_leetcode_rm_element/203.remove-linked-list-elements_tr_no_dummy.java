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
    /* without dummy head */
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur, tmp, prev = null;
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null)
            return null;
        cur = head;
        while (cur.next != null){
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else 
                cur = cur.next;
        }
        return head;
    }
}
// @lc code=end

