package medium;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        HashMap<Integer,Integer> m = new HashMap<>();
        for (int num:nums){
            m.put(num,0);
        }
        int res = 0;
        for (int cur:m.keySet()){
            int a = cur-1;
            int b = cur+1;
            while (m.containsKey(a)){
                int tmpIndex = m.get(cur)+1;
                m.put(cur,tmpIndex);
                a = a-1;
                if (tmpIndex>res){
                    res = tmpIndex;
                }
            }
            while (m.containsKey(b)){
                int tmpIndex = m.get(cur)+1;
                m.put(b,tmpIndex);
                b = b+1;
                if (tmpIndex>res){
                    res = tmpIndex;
                }
            }
        }
        if (res==1){
            return res+1;
        }
        return res/2;
    }
    public static void main(String[] args) {
        int[] input = new int[]{-1,0,1};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(input));
        HashSet<Integer> s = new HashSet<>();
        s.add(1);
        for (int a:s){

        }
    }
}
