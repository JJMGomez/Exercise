package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexChild = 0;
        int indexChoc = 0;
        while (indexChild < g.length && indexChoc < s.length){
            if (g[indexChild] <= s[indexChoc]){
                indexChoc++;
                indexChild++;
            }
            else{
                indexChoc++;
            }
        }
        return indexChild;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.print(findContentChildren(g,s));
    }
}
