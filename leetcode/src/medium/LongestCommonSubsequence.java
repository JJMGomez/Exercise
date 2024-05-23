package medium;

import java.util.Stack;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (text1Char[i-1] == text2Char[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
//        String s1 = "bsbininm";
//        String s2 = "jmjkbkjkv";
        String s1 = "abcce";
        String s2 = "ace";
        System.out.print(longestCommonSubsequence(s1,s2));
    }
}
