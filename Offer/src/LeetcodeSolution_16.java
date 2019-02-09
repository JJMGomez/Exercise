import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeSolution_16 {
    public int threeSumClosest(int[] nums, int target) {

        if (nums.length<3){
            return target;
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int diff = target-result;
        if (nums.length==3)
        {
            return result;
        }


        for (int i=0; i<nums.length-1; i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {

                int diff_current = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), target-nums[i], diff);
                if (Math.abs(diff_current)<Math.abs(diff)){
                    diff = diff_current;
                    result = target-diff;
                }
            }
        }

        return result;
    }

    public static int twoSum(int[] nums, int target, int diff){
        int left = 0, right = nums.length-1;
        while(left<right){
            int diff_current = target-(nums[left]+nums[right]);
            if (diff_current>0){
                if (Math.abs(diff_current)<Math.abs(diff)){
                    diff = diff_current;
                }
                left++;
            }
            else if (diff_current<0){
                if (Math.abs(diff_current)<Math.abs(diff)){
                    diff = diff_current;
                }
                right--;
            }
            else{
                diff =  diff_current;
                return diff;
            }
        }
        return diff;
    }

    public static void main(String[] args){
        LeetcodeSolution_16 solution1 = new LeetcodeSolution_16();
        int a[] = {0,2,1,-3};
        //{-4, -1, 1, 2}
        //{1,1,1,0} -100
        //{0,2,1,-3},1
        System.out.print(solution1.threeSumClosest(a,1));
    }
}
