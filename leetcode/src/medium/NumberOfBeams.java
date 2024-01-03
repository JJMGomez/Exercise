package medium;

import java.util.ArrayList;

/**
 * Leetcode 2125
 * date: 2024/1/3
 * */
public class NumberOfBeams {
    public static int numberOfBeams(String[] bank) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=0; i< bank.length; i++){
            char[] curBank = bank[i].toCharArray();
            int curRowCount = 0;
            for (int j=0; j< curBank.length; j++){
                if (curBank[j] == '1'){
                    curRowCount++;
                }
            }
            if (curRowCount != 0){
                nums.add(curRowCount);
            }
        }
        int res = 0;
        for (int i=1; i<nums.size(); i++){
            res += nums.get(i-1) * nums.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] bank = new String[]{"000","111","000"};
        System.out.print(numberOfBeams(bank));
    }
}
