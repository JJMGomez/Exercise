package medium;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxWidthOfVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        ArrayList<Integer> p = new ArrayList<>();
        for (int i=0; i<points.length; i++){
            p.add(points[i][0]);
        }
        p.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int maxWidth = 0;
        for (int i=1; i< points.length; i++){
            if (p.get(i)-p.get(i-1) > maxWidth){
                maxWidth = p.get(i)-p.get(i-1);
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{8,7},{9,9},{7,4},{9,7}};
        MaxWidthOfVerticalArea case1 = new MaxWidthOfVerticalArea();
        case1.maxWidthOfVerticalArea(input);
    }
}
