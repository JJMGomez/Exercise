package medium;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
/**
 * Leetcode: 735
 * */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int item: asteroids){
            if (!stack.isEmpty() && item<0){
                if (stack.peek() < 0){
                    stack.push(item);
                }else if(stack.peek()>0){
                    while (!stack.isEmpty() && stack.peek()>0 && stack.peek() < Math.abs(item)) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek()< 0){
                        stack.push(item);
                    }
                    if (stack.peek() == Math.abs(item)){
                        stack.pop();
                    }
                }
            }else{
                stack.push(item);
            }
        }
        int num = stack.size();
        int[] result = new int[num];

        for (int i=num-1; i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{8,-8};
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        asteroidCollision.asteroidCollision(input);
        Set<Integer> set1 = new HashSet<>();
        LinkedList<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);

    }
}
