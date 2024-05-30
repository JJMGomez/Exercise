package medium;

/**
 * Leetcode:328
 * */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy;
        ListNode p2 = dummy2;
        while (head!=null && head.next!=null){
            p1.next = head;
            p1 = p1.next;
            head = head.next;

            p2.next = head;
            p2 = p2.next;
            head = head.next;
        }
        p2.next = null;
        if (head!=null){
            p1.next = head;
            p1 = p1.next;
        }
        p1.next = dummy2.next;
        return dummy.next;
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
        ListNode res = oddEvenList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
