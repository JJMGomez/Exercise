package hard;

import medium.swapPairs;

/**
 * 收尾交换+链表反转
 * */
public class reverseKGroup {
    public static void main(String[] args){
        swapPairs swapPairs = new swapPairs();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(5);

        ListNode result = reverseKGroup.reversekGroup(node,2);
        System.out.println(result.val);
    }

    public static ListNode reversekGroup(ListNode head, int k){
        ListNode newHead = head;
        for (int i=0; i<k-1; i++){
            if (null == newHead){
                return head;
            }
            newHead = newHead.next;
        }

        //假头
        ListNode left = new ListNode(-1);
        left.next = head;
        ListNode pre = null;
        while (true){
            ListNode preHead = head;
            for (int i=0; i<k; i++){
                //第一次遍历k个节点时，最后一个节点叫newHead，最后它将被翻转为头节点。
                if (head == null){
                    return newHead;
                }
                ListNode next = head.next;
                pre = head;
                head = next;
            }
            left.next = pre;
            left = reverse(preHead,k);
            left.next = head;
        }
    }

    /**
     * 链表反转
     * */
    public static ListNode reverse(ListNode head, int k){
        ListNode pre = null;
        ListNode cur = head;
        ListNode tail = head;
        while(null != cur.next && k>0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        return tail;
    }

}
