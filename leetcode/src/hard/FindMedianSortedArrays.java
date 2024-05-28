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

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int i=0,j=0,index=0;
        int m=nums1.length, n=nums2.length;
        int a1=-1,a2=-1;
        while (i<m && j<n){
            if (index > (m+n)/2){
                break;
            }
            a1 = a2;
            if (nums1[i] <= nums2[j]){
                a2=nums1[i];
                i++;
                index++;
            }else{
                a2=nums2[j];
                j++;
                index++;
            }
        }
        if (i>=m){
            while (index<=(m+n)/2){
                a1 = a2;
                a2 = nums2[j];
                j++;
                index++;
            }
        }
        else if (j>=n){
            while (index<=(m+n)/2){
                a1 = a2;
                a2 = nums1[i];
                i++;
                index++;
            }
        }
        if ((m+n)%2 != 0){
            return (float)a2;
        }else{
            return (float)(a1+a2)/2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays2(nums1,nums2));
    }
}
