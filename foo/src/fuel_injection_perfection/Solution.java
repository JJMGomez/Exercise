package fuel_injection_perfection;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * solutionA：greedy algorithm
 * solutionB：recursion
 * */
public class Solution {
    public static Map<BigInteger, Integer> map = new HashMap<>();

    public static int solutionB(String x){
        BigInteger input = new BigInteger(x);
        return solution(input);
    }

    public static int solution(BigInteger input) {
        int count;
        if (input.equals(BigInteger.valueOf(1))) {
            return 0;
        }
        if (null != map.get(input)) {
            return map.get(input);
        }
        if (input.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            count = solution(input.divide(BigInteger.valueOf(2))) + 1;
        } else {
            count = Math.min(solution(input.add(BigInteger.valueOf(1))), solution(input.subtract(BigInteger.valueOf(1)))) + 1;
        }
        map.put(input, count);
        return count;
    }



    public static int solutionA(String x){
        BigInteger input = new BigInteger(x);
        int count = 0;
        while (!input.equals(BigInteger.valueOf(1))){
            if (input.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))){
                input = input.divide(BigInteger.valueOf(2));
            }
            else if(input.equals(BigInteger.valueOf(3)) || input.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(1))){
                input = input.subtract(BigInteger.valueOf(1));
            }
            else{
                input = input.add(BigInteger.valueOf(1));
            }
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solutionA("15"));
        System.out.println(solutionB("15"));
    }
}
