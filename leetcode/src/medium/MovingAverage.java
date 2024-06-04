package medium;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> q = new LinkedList<>();
    private int size;
    private long sum=0;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (q.size() == size){
            sum -= q.poll();
            q.add(val);
            sum += val;
        }else{
            q.add(val);
            sum += val;
        }
        return (double)sum/q.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
        System.out.println(movingAverage.next(9));
    }
}
