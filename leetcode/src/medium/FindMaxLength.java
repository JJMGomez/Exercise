package medium;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int prefixIndex = -1;
        map.put(prefixSum,prefixIndex);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                prefixSum++;
            } else {
                prefixSum--;
            }
            if (map.containsKey(prefixSum)) {
                prefixIndex = map.get(prefixSum);
                maxLength = Math.max(maxLength, i - prefixIndex);
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        FindMaxLength findMaxLength = new FindMaxLength();
        System.out.println(findMaxLength.findMaxLength(nums));
    }
}
