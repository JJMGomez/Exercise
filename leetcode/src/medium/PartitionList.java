package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode max = new ListNode(-1);
        max.next = head;
        head = max;
        ListNode p = head;
        while (null != p.next){
            if (p.next.val >= x){
                break;
            }else{
                max = max.next;
                p = p.next;
            }
        }
        while (null != p.next){
            if (p.next.val < x){
                ListNode minNext = p.next.next;
                p.next.next = max.next;
                max.next = p.next;
                p.next = minNext;
                max = max.next;
            }
            else {
                p = p.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(4);
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;
//        ListNode node3 = new ListNode(1);
//        node2.next = node3;
//        ListNode node4 = new ListNode(3);
//        node3.next = node4;
//        ListNode node5 = new ListNode(2);
//        node4.next = node5;
//        ListNode node6 = new ListNode(5);
//        node5.next = node6;
//        ListNode node7 = new ListNode(2);
//        node6.next = node7;
//        partition(node1,3);

        int[] nums = new int[]{31,123,4,0,0};
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++){
            sb.append(nums[i]);
        }
        String res = sb.toString();
        int index = 0;
        while(res.charAt(index) == '0'){
            index ++;
        }

    }


}
