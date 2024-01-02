package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMatrix {
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> countMap = new HashMap<>();
        int max = 1;
        for (int i=0; i< nums.length; i++){
            if (countMap.containsKey(nums[i])){
                int tmpCount = countMap.get(nums[i]) + 1;
                if (tmpCount > max){
                    max = tmpCount;
                }
                countMap.put(nums[i],tmpCount);
            }else{
                countMap.put(nums[i],1);
            }
        }
        for (int i=0; i<max; i++){
            List<Integer> tmp = new ArrayList<>();
            for (Integer key : countMap.keySet()){
                if (countMap.get(key)>0){
                    tmp.add(key);
                    int count = countMap.get(key) -1;
                    countMap.put(key,count);
                }
            }
            res.add(tmp);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,4,1,2,3,1};
        findMatrix(input);
    }
}
