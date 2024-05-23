package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode:179
 * */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        Integer[] input = new Integer[nums.length];
        for (int i=0; i<nums.length; i++){
            input[i] = nums[i];
        }
        Arrays.sort(input, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String as = a.toString();
                String bs = b.toString();
                String t1 = as +""+bs;
                String t2 = bs +""+as;
                return t2.compareTo(t1) ;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.length; i++){
            sb.append(input[i]);
        }
        String res = sb.toString();
        int index = 0;
        while(index<res.length() && res.charAt(index) == '0'){
            index ++;
        }
        return res.substring(index).equals("")? "0":res.substring(index);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.print(largestNumber(nums));
    }
}
