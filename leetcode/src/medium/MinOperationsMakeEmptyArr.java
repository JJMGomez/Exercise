package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 2870
 * date：2024/1/4
 * */
public class MinOperationsMakeEmptyArr {
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums){
            if (countMap.containsKey(num)){
                int curCount = countMap.get(num);
                countMap.put(num,curCount+1);
            }else {
                countMap.put(num,1);
            }
        }
        int res = 0;
        for (Integer value: countMap.values()){
            if (value == 1){
                return -1;
            }
            if (value % 3 == 0){
                res += value / 3;
            }else{
                res += value / 3 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,3,2,2,4,2,3,4};
        System.out.print(minOperations(input));
    }
}
