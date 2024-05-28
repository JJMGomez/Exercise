package medium;

/**
 * Leetcode:92*/
public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = head;
        head = pre;
        for (int i=1; i<left; i++){
            pre = pre.next;
            cur = cur.next;
        }
        ListNode dummy = new ListNode();
        ListNode tail = cur;
        for (int i=left; i<=right; i++){
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }
        pre.next = dummy.next;
        while(cur!=null){
            tail.next = cur;
            cur = cur.next;
            tail = tail.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        reverseBetween(head,2,4);
//        ListNode head = new ListNode(5);
    }
}
