package medium;
/**
 * Leetcode 300
 * date：2024/1/5
 * */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        for (int i=0; i<dp.length; i++){
            dp[i] = 1;
        }
        int res = 1;
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[i] > res){
                        res = dp[i];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.print(lengthOfLIS(nums));
    }
}
