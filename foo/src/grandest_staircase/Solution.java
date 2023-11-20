package grandest_staircase;

public class Solution {
    public static int count = 0;
    public static int[][] res;


    public static int solutionB(int n){
        res = new int[n+1][n+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                res[i][j] = -1;
            }
        }
        return recurSolutionB(1,n)-1;
    }
    public static int recurSolutionB(int pre, int remain){
        if (remain == 0){
            return 1;
        }
        if (remain <0 || pre > remain){
            return 0;
        }
        if (res[pre][remain] != -1){
            return res[pre][remain];
        }
        int count =0;
        for (int i=pre; i<=remain; i++){
            count += recurSolutionB(i+1,remain -i);
        }
        res[pre][remain] = count;
        return count;
    }


    public static int solution(int n){
        for (int i=1; i<n; i++){
            recurSolution(i,n-i);
        }
        return count;
    }
    public static void recurSolution(int pre, int remain){
        if (remain == 0){
            count ++ ;
            return;
        }
        for (int i=pre+1; i<=remain; i++){
            recurSolution(i,remain -i);
        }
    }

    public static void main(String[] args) {
        System.out.println(solutionB(10));
    }
}
