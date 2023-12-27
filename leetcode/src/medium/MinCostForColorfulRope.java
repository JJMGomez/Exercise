package medium;

public class MinCostForColorfulRope {
    public static int minCost(String colors, int[] neededTime) {
        char[] ropes = colors.toCharArray();
        int curMax = 0;
        int result = 0;
        if (neededTime.length == 1) return 0;
        int i=1;
        while(i<ropes.length){
            int curResult = neededTime[i-1];
            curMax = neededTime[i-1];
            while (i<ropes.length && ropes[i]==ropes[i-1]){
                curResult += neededTime[i];
                curMax = Math.max(Math.max(neededTime[i], neededTime[i-1]),curMax);
                i++;
            }
            i++;
            curResult -= curMax;
            result += curResult;
        }
        return result;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = new int[]{1,2,3,4,5};
        System.out.print(minCost(colors,neededTime));
    }
}
