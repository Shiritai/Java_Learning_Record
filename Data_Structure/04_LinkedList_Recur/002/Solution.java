// import java.util.List;


class Solution_ {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return (head.val == val) ? head.next : head;
    }

    public static void main(String [] args){
        int [] arr = {6, 6, 1, 2, 6, 4, 5, 6, 7, 9, 6, 6, 6, 1, 6, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode tmp = (new Solution_()).removeElements(head, 6);
        System.out.println(tmp);
    }
}

