package medium;


import java.util.*;

/**
 * Leetcode:1429
 * */
public class FirstUnique {
    Map<Integer, Integer> numCount;
    Queue<Integer> queue;
    public FirstUnique(int[] nums) {
        numCount = new HashMap<>();
        queue = new LinkedList<>();
        for (int item: nums){
            add(item);
        }
    }
    public int showFirstUnique() {
        while (!queue.isEmpty()){
            if (numCount.get(queue.peek()) > 1){
                queue.poll();
            }
            else{
                return queue.peek();
            }
        }
        return -1;
    }
    public void add(int value) {
        if (numCount.containsKey(value)){
            numCount.put(value,numCount.get(value) +1);
        }else{
            numCount.put(value,1);
            queue.offer(value);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,5};
        FirstUnique firstUnique = new FirstUnique(num);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(2);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());
        Stack<Integer> stack = new Stack<>();
        
    }
}
