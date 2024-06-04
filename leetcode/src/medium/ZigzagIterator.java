package medium;

import java.util.*;
/**
 * Leetcode: 281
 * */
public class ZigzagIterator {
    private Queue<Iterator> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if (!v1.isEmpty()){
            q.offer(v1.iterator());
        }
        if (!v2.isEmpty()){
            q.offer(v1.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iterator = q.poll();
        int item =  iterator.next();
        if (iterator.hasNext()){
            q.offer(iterator);
        }
        return item;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        v1.add(7);
        v2.add(3);
        v2.add(4);
        v2.add(5);
        ZigzagIterator i = new ZigzagIterator(v1, v2);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

