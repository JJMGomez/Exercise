package hard;

import java.util.PriorityQueue;

public class mergeKLists {

    public static final int NUM_NULL = 20000;

    public static void main(String[] args){
        mergeKLists mergeKLists = new mergeKLists();

        ListNode[] lists = new ListNode[3];
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        lists[0] = node;

        node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        lists[1] = node;

        node = new ListNode(2);
        node.next = new ListNode(6);
        lists[2] = node;

        ListNode result = mergeKLists.mergeKLists(lists);
        System.out.println(result.val);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length==0){
            return null;
        }
        //放最终结果
        ListNode head = new ListNode();
        ListNode result = head;

        //放各list的头
        int[] heads = new int[lists.length];
        for (int i=0; i<lists.length; i++) {
            if (null != lists[i]){
                heads[i] = lists[i].val;
            }else{
                heads[i] = NUM_NULL;
            }
        }

        //所有节点入新链后结束
        while(getMinIndex(heads) != -1){
            int minindex = getMinIndex(heads);
            head.next = lists[minindex];
            head = head.next;
            if (null != lists[minindex].next) {
                heads[minindex] = lists[minindex].next.val;
                lists[minindex] = lists[minindex].next;
            }
            else{
                heads[minindex] = 20000;
            }
        }
        return result.next;
    }

    public int getMinIndex(int[] heads){
        int min = heads[0];
        int index = 0;
        for (int i=0; i<heads.length; i++){
            if (heads[i]<min){
                min = heads[i];
                index = i;
            }
        }
        //当最小值就是NUM_NULL时，说明结束了
        if (min == NUM_NULL){
            return -1;
        }
        return index;
    }

    public ListNode mergeKLists2(ListNode[] lists){
        if(lists.length ==0 || lists == null) {
            return null;
        }
        // use a priority queue to store and get the smallest node
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val-b.val));
        // to avoid the issues with an empty pointer, using a dummy node
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // add the head of each list to the priority queue
        for(ListNode head:lists){
            if(head != null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            // find the smallest node and add it to the list
            ListNode node = pq.poll();
            p.next = node;
            // add more nodes from multiple sublists to the priority queue
            if(node.next != null){
                pq.add(node.next);
            }
            // continuously move the pointer
            p = p.next;
        }
        return dummy.next;
    }

}
