package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode:215
 * */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int item: nums){
            queue.add(item);
        }
        for (int i=0; i<k-1; i++){
            queue.poll();
        }

        return queue.peek();
    }
    public int findKthLargest1(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        int curr = partition(nums,left,right);
        while (curr+1 != k){
            if (curr+1 > k){
                right = curr-1;
                curr = partition(nums,left,right);
            }else{
                left = curr +1;
                curr = partition(nums,left,right);
            }
        }
        return nums[curr];
    }

    public int partition(int[] nums, int left, int right){

        int i=left, j=right;
        int pivot = nums[i];
        while(i < j){
            while(i < j && nums[j] <= pivot){
                j--;
            }
            while(i < j && nums[i] >= pivot){
                i++;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,1,5,6,4};
//        KthLargestElement case1 = new KthLargestElement();
//        System.out.print(case1.findKthLargest1(nums,2));
        System.out.print( 1/2);

    }
}
