package medium;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 31
 * */

public class NextPermutation {
    public static void main(String[] args){
        NextPermutation nextPermutation = new NextPermutation();
        int[] array = new int[]{1,1,2};
        nextPermutation.nextPermutation(array);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length<2){
            return;
        }
        int index = nums.length-1;
        if (nums[index] > nums[index-1]){
            swap(nums,index, index-1);
            return;
        }

        //从右往左找到第一个逆序的数 比如 2341中3
        index = nums.length-2;
        while(index>=0 && nums[index]>=nums[index+1]){
            index--;
        }
        if (index >= 0){
            int j = nums.length - 1;
            while(nums[j]<=nums[index]){
                j--;
            }
            swap(nums,index,j);
        }
        reverse(nums, index+1);
    }

    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
        while (i<j){
            swap(nums, i ,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
