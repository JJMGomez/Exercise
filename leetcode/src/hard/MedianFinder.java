package hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    public MedianFinder() {

    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minQue = new PriorityQueue<>(Collections.reverseOrder());
        minQue.add(4);
        minQue.add(6);
        minQue.add(2);
        minQue.add(1);
        while (0 != minQue.size()){
            System.out.println(minQue.poll());
            System.out.println(minQue.peek());
        }
    }
}
