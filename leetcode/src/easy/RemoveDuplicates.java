package easy;

public class RemoveDuplicates {
    public static void main(String[] args){
        int[] array = new int[]{1,1,2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(array);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if (nums[right] > nums[left]){
                left ++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }
}
