import java.text.CharacterIterator;

// import java.util.List;


class Solution_ {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode result = removeElements(head.next, val);
        if (head.val == val){
            return result;
        }
        else {
            head.next = result; // 接收下一個非 val 的序列
            return head;
        }
    }

    public static void main(String [] args){
        int [] arr = {6, 6, 1, 2, 6, 4, 5, 6, 7, 9, 6, 6, 6, 1, 6, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode tmp = (new Solution_()).removeElements(head, 6);
        System.out.println(tmp);
    }
}