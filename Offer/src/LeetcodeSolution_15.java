import java.util.*;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
//Find all unique triplets in the array which gives the sum of zero.
//Given array nums = [-1, 0, 1, 2, -1, -4],
////        A solution set is:
////        [
////        [-1, 0, 1],
////        [-1, -1, 2]
////        ]
public class LeetcodeSolution_15 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-1; i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
                List<List<Integer>> current = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), 0 - nums[i]);
                if (current != null) {
                    for (int j = 0; j < current.size(); j++) {
                        result.add(current.get(j));
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = nums.length-1;
        while(left<right){
            if (nums[left]+nums[right]==target){
                List<Integer> current = new ArrayList<>();
                current.add(0-target);
                current.add(nums[left]);
                current.add(nums[right]);
                result.add(current);
                while(left<right && nums[left]==nums[left+1]) left++;
                while(left<right && nums[right]==nums[right-1]) right--;
                left++;
                right--;
            }
            else if (nums[left]+nums[right]<target) left++;
            else right--;
        }
        return result;
    }

    public static void main(String[] args){
        LeetcodeSolution_15 solution1 = new LeetcodeSolution_15();
        int a[] = {-1,0,1,2,-1,-4};//{-4, -1, -1, 0, 1, 2}
        System.out.print(solution1.threeSum(a));
    }
}
