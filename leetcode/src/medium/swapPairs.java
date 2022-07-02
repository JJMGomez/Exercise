package medium;

public class swapPairs {
    public static void main(String[] args){
        swapPairs swapPairs = new swapPairs();

        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);

        ListNode result = swapPairs.swapPairs(node);
        System.out.println(result.val);
    }

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next){
            return head;
        }

        //假头
        ListNode left = new ListNode(-1);
        ListNode result = left;
        left.next = head;

        while (null != left.next && null != left.next.next){
            ListNode current = left.next;
            ListNode right = current.next;

            current.next = right.next;
            right.next = current;
            left.next = right;

            left = left.next.next;

        }

        return result.next;
    }
}
