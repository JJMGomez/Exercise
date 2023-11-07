package hard;


import java.text.DecimalFormat;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergeAry = new int[m+n];
        int num1Index = 0;
        int num2Index = 0;
        int mergeIndex = 0;
        while(num1Index < m && num2Index < n){
            if (nums1[num1Index] <= nums2[num2Index]){
                mergeAry[mergeIndex] = nums1[num1Index];
                num1Index ++;
            }
            else{
                mergeAry[mergeIndex] = nums2[num2Index];
                num2Index ++;
            }
            mergeIndex ++;
        }
        if (num1Index < m){
            for (int i = num1Index; i<m; i++){
                mergeAry[mergeIndex] = nums1[i];
                mergeIndex++;
            }
        }
        if (num2Index < n){
            for (int i=num2Index; i<n; i++){
                mergeAry[mergeIndex] = nums2[i];
                mergeIndex++;
            }
        }

        if ((m+n)%2 == 0){
            return (double)(mergeAry[(m+n)/2-1] + mergeAry[(m+n)/2])/2;
        }
        else{
            return mergeAry[(m+n)/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0};
        int[] nums2 = new int[]{0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
