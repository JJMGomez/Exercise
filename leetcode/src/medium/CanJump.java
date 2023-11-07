package medium;

import java.util.HashMap;
import java.util.Map;

public class CanJump {
    public boolean canJump(int[] nums) {
        
        int maxFar = 0;
        for (int i=0; i< nums.length; i++){
            if (i > maxFar){
                return false;
            }
            maxFar = Math.max(nums[i]+i, maxFar);
        }
        if (maxFar < nums.length - 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        CanJump case1 = new CanJump();
        System.out.println(case1.canJump(nums));
    }
}
