package medium;
import java.util.*;
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0,j=0;
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = m;
        int up = 0, down = n;
        List<Integer> res = new ArrayList<>();
        char direct = 'r';//l (left) r (right) u(up) d(down)

        while (left < right && up <down){
            if (direct == 'r'){
                for (j = left; j < right; j++){
                    res.add(matrix[i][j]);
                }
                j--;
                up++;
                direct = 'd';
            }
            else if (direct == 'd'){
                for (i=up; i < down; i++){
                    res.add(matrix[i][j]);
                }
                i--;
                right--;
                direct = 'l';
            }
            else if (direct == 'l'){
                for (j=right-1; j>=left; j--){
                    res.add(matrix[i][j]);
                }
                j++;
                down --;
                direct = 'u';
            }
            else if (direct =='u'){
                for (i=down-1; i>=up; i--){
                    res.add(matrix[i][j]);
                }
                i++;
                left ++;
                direct = 'r';
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralMatrix.spiralOrder(input);
    }
}
